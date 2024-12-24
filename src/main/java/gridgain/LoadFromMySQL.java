package gridgain;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
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
        Ignite ignite = Ignition.start(cfg);

    }
}
