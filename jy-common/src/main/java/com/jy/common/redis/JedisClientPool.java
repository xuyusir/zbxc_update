package com.jy.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class JedisClientPool implements JedisClient {

	private JedisPool jedisPool;

	/**
	 * redis编码(部署多个环境,使用共同reids时,区分环境使用)
	 */
	private String redisType;

	/**
	 * 是否部署多个环境
	 */
	private boolean isMore;

	public String getRedisType() {
		return redisType;
	}

	public void setRedisType(String redisType) {
		this.redisType = redisType;
	}

	public boolean getIsMore() {
		return isMore;
	}

	public void setIsMore(boolean isMore) {
		this.isMore = isMore;
	}

	private static final String REDISTYPEPRE = "type_";

	private String getKey(String key){
		if (isMore){
			return REDISTYPEPRE + redisType + "_" + key;
		}else {
			return key;
		}
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	@Override
	public String set(String key, String value,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		String result = jedis.set(getKey(key), value);
		jedis.close();
		return result;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(getKey(key), value);
		jedis.close();
		return result;
	}

	@Override
	public String get(String key,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		String result = jedis.get(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Long del(String key,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		Long result = jedis.del(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Boolean exists(String key,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		Boolean result = jedis.exists(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Boolean exists(String key) {
		Jedis jedis = jedisPool.getResource();
		Boolean result = jedis.exists(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Long expire(String key, int seconds,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		Long result = jedis.expire(getKey(key), seconds);
		jedis.close();
		return result;
	}

	@Override
	public Long expire(String key, int seconds) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(getKey(key), seconds);
		jedis.close();
		return result;
	}

	@Override
	public Long ttl(String key,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		Long result = jedis.ttl(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		Long result = jedis.incr(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(getKey(key));
		jedis.close();
		return result;
	}

	@Override
	public Long hset(String key, String field, String value,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		Long result = jedis.hset(getKey(key), field, value);
		jedis.close();
		return result;
	}

	@Override
	public Long hset(String key, String field, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(getKey(key), field, value);
		jedis.close();
		return result;
	}

	@Override
	public String hget(String key, String field,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		String result = jedis.hget(getKey(key), field);
		jedis.close();
		return result;
	}

	@Override
	public String hget(String key, String field) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(getKey(key), field);
		jedis.close();
		return result;
	}

	@Override
	public List<String> hvals(String key,String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		List<String> list = jedis.hvals(getKey(key));
		jedis.close();
		return list;
	}

	@Override
	public List<String> hvals(String key) {
		Jedis jedis = jedisPool.getResource();
		List<String> list = jedis.hvals(getKey(key));
		jedis.close();
		return list;
	}

	@Override
	public Long hdel(String password,String key, String... field) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		Long result = jedis.hdel(getKey(key), field);
		jedis.close();
		return result;
	}

	@Override
	public Long hdel(String key, String... field) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(getKey(key), field);
		jedis.close();
		return result;
	}

	@Override
	public boolean hexists(String key, String field,String password){
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		boolean b = jedis.hexists(getKey(key), field);
		jedis.close();
		return b;
	}

	@Override
	public boolean hexists(String key, String field){
		Jedis jedis = jedisPool.getResource();
		boolean b = jedis.hexists(getKey(key), field);
		jedis.close();
		return b;
	}

	@Override
	public Jedis getJedis(String password) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth(password);
		return jedis;
	}

}
