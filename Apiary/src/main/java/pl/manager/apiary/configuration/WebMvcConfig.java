package pl.manager.apiary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import pl.manager.apiary.controller.converter.StringToItemCategoryConverter;

@Component
public class WebMvcConfig extends WebMvcConfigurationSupport {
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToItemCategoryConverter());
		super.addFormatters(registry);
	}

	@Bean
	public StringToItemCategoryConverter stringToItemCategoryConverter() {
		return new StringToItemCategoryConverter();
	}
}
