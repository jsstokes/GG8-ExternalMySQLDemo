package gridgain;

import externalMySQL.Person;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

import java.util.Collections;

public class LoadFromMySQL {
    public static void main(String[] args) {
        System.out.println("Running main for:" + LoadFromMySQL.class.getName());

        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setPeerClassLoadingEnabled(true);
        cfg.setClientMode(true);
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(Collections.singletonList("127.0.0.1:47500..47509"));
        cfg.setDiscoverySpi(new TcpDiscoverySpi().setIpFinder(ipFinder));
        Ignition.setClientMode(true);
        Ignite ignite = Ignition.start("/Users/scott.stokes/projects/ExternalMySQLDemo/src/main/resources/mysql-pojo-config.xml");

        IgniteCache<Integer, Person> personCache = ignite.getOrCreateCache("PersonCache");

        Person newPerson = new Person();
        newPerson.setId(99);
        newPerson.setName("George Jetson");
        personCache.put(99, newPerson);

        SqlFieldsQuery query = new SqlFieldsQuery("insert into PERSON(id,name) values(?,?)");
        query.setArgs(98, "Jane Jetson");
        personCache.query(query);


    }
}
