package jedistest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

/**
 * @author mengqa
 * @create 2018-06-06 15:38
 **/
public class JedisTest {

    /**
     * 测试单机版jedis
     */
    @Test
    public void testJedisSingle() {
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.set("mqa-key", "mqa-value");
        String value = jedis.get("mqa-key");
        System.out.println(value);
        jedis.close();
    }

    /**
     * 测试jedis连接池
     */
    @Test
    public void testJedisPool() {
        //创建jedis连接池
        JedisPool pool = new JedisPool("192.168.1.104", 6379);
        //从连接池中获得Jedis对象
        Jedis jedis = pool.getResource();
        String string = jedis.get("mqa-key");
        System.out.println(string);
        //关闭jedis对象
        jedis.close();
        pool.close();

    }

    /**
     * 测试jedis集群版，自带连接池
     */
    @Test
    public void testJedisCluster() {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.1.104", 7001));
        nodes.add(new HostAndPort("192.168.1.104", 7002));
        nodes.add(new HostAndPort("192.168.1.104", 7003));
        nodes.add(new HostAndPort("192.168.1.104", 7004));
        nodes.add(new HostAndPort("192.168.1.104", 7005));
        nodes.add(new HostAndPort("192.168.1.104", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("key1", "1000");
        String string = cluster.get("key1");
        System.out.println(string);

        cluster.close();
    }


    /**
     * 单机spring整合jedis测试
     */
    @Test
    public void testSpringJedisSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        String string = jedis.get("mqa-key");
        System.out.println(string);
        jedis.close();
        pool.close();
    }

    /**
     * 集群版Spring整合jedis测试
     */
    @Test
    public void testSpringJedisCluster() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisCluster jedisCluster =  (JedisCluster) applicationContext.getBean("redisClient");
        String string = jedisCluster.get("key1");
        System.out.println(string);
        jedisCluster.close();
    }


}
