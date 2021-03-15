package com.sjm.PlayingCards.service;

public interface RedisService {
    /**
     * redis操作Service
     * 对象和数组都以json形式存储
     * @param key
     * @param value
     */
    void set(String key,String value);

    /**
     * 读取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key, long delta);
}
