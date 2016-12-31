package commons.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisCache {
	private static JedisPool pool;
	
	public Jedis getJedis() {
		return pool.getResource();
	}
	
	public Long zadd(String key,long score,String member,Long timeout) {
		Long suc = null;
		try(Jedis jedis = getJedis()) {
			suc = jedis.zadd(key, score, member);
			if(timeout != null && timeout > 0) {
				jedis.pexpire(key, timeout);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return suc;
	}
}
