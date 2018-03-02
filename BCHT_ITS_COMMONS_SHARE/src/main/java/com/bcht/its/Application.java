package com.bcht.its;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

/**
 * 分布式共享内存服务
 */
public class Application {

    public static void main(String[] args){
        //创建CacheFactory
        ClientCacheFactory cf = new ClientCacheFactory().addPoolServer("localhost",40404);
        //利用CF创建ClientCache
        ClientCache cache = cf.setPdxReadSerialized( true).create();
        //域工厂 这里的域可以理解成表
        ClientRegionFactory rf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);

        //创建一个region (表)
        Region region = rf.create("DJGL_T_SBXX");
        //region.
        region.put("taoshide","taoshide");
    }
}
