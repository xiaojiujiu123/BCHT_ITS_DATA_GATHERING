package com.bcht.its.data.share;

import java.util.HashMap;

/**
 * 全局共享变量
 * Created by taoshide on 2017/5/10.
 */
public class ShareVar<K,V>  extends HashMap<K,V> {
    /**自定义一个Map结构，用于存入key的当前状态*/
    private HashMap<K,Boolean> keyState = new HashMap<K, Boolean>();

    @Override
    public V put(K key, V value) {
        keyState.put(key,true);
        return super.put(key, value);
    }

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    public static void main(String[] args){
        ShareVar<String,Object> var = new ShareVar<String,Object>();

    }

}


