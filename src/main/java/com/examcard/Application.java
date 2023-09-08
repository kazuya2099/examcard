package com.examcard;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.examcard.exception.ExceptionLogger;
import com.examcard.filter.ExceptionLoggingFilter;

@ComponentScan(basePackages = "com.examcard")
@Import({DatasourceConfig.class, SecurityConfig.class})
@SpringBootApplication
public class Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public	LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String[] mappings = {"/resources/**", "/css/**", "/javascript/**"};
		String[] locations = {"/resources/", "/css/", "/javascript/"};
		registry.addResourceHandler(mappings).addResourceLocations(locations);
	}

	@Bean
	SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		Properties mappings = new Properties();
		mappings.setProperty("com.examcard.exception.SystemException", "error/systemError");
		mappings.setProperty("com.examcard.exception.BusinessException", "error/businessError");
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
		simpleMappingExceptionResolver.setOrder(1);
		simpleMappingExceptionResolver.setExceptionMappings(mappings);
		simpleMappingExceptionResolver.setExcludedExceptions(new Class<?>[] {
			org.springframework.security.access.AccessDeniedException.class,
		});
		simpleMappingExceptionResolver.setExcludedExceptions(AccessDeniedException.class);
		return simpleMappingExceptionResolver;
	}

	@Bean
	ExceptionLogger exceptionLogger() {
		ExceptionLogger exceptionLogger = new ExceptionLogger();
		return exceptionLogger;
	}

	@Bean
	ExceptionLoggingFilter exceptionLoggingFilter(ExceptionLogger exceptionLogger) {
		ExceptionLoggingFilter exceptionLoggingFilter = new ExceptionLoggingFilter();
		exceptionLoggingFilter.setExceptionLogger(exceptionLogger);
		return exceptionLoggingFilter;
	}
}
