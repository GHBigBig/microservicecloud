package com.zjg.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 自定的 IRule :
 *      轮询调用但是每个服务调用 5 次
 * @author zjg
 * @create 2020-01-01 20:55
 */
public class MyRoundRule extends AbstractLoadBalancerRule {
    private static final int COUNT = 5;
    //total = 0     //当 total == 5 以后，我们指针才能往下走，
    //index = 0     //表示当前对外提供服务的服务器地址
    // total 需要重新置为零，但是已经达到过一个 5 次，我们的index =1
    private int total  = 0;         //总共被调用的次数，目前要求每台调用 5 次
    private int currentIndex = -1;   //当前提供服务的机器号

     public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            /*int index = chooseRandomInt(serverCount);
            server = upList.get(index);*/
            if (total==0) {
                /*
                    我是属于每一轮的，我要在每一轮发挥作用
                    如果我写打了 total = ++total%COUNT; 后面，
                    那么就成了第一轮的变为下一轮的，每轮的情况都类似。。。。
                 */
                currentIndex = ++currentIndex%upList.size();
//                System.out.println("============= currentIndex : " + currentIndex);
            }
            total = ++total%COUNT;
//            System.out.println("============= total : " + total);


            server = upList.get(currentIndex);


            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;
    }



    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}