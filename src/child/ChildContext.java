package child;

import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:proxy-host.properties")
public class ChildContext {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ChildContext.class);
	@Autowired
	private Environment environment;

	@Resource(name = "proxyChannelQueue")
	private BlockingQueue<Object> proxyChannelQueue;

	@Bean
	public Object getJettyServer() throws Exception {
		int proxyHostPort = environment.getProperty("proxyHostPort",
				Integer.class);

		return new Test(proxyHostPort);
	}

}