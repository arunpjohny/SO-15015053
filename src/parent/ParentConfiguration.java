package parent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParentConfiguration {
	@Bean(name = "proxyChannelQueue")
	public BlockingQueue<Object> getProxyChannelQueue() {
		return new ArrayBlockingQueue<Object>(10);
	}
}