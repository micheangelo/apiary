package pl.manager.apiary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.manager.apiary.model.Cost;

@Configuration
@ComponentScan
public class RootConfiguration {
	
	@Bean
	public Cost getNewCost() {
		return new Cost("test description");
	}
}
