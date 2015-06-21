/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.proyecto.cero.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.mustache.MustacheTemplateLoader;
import org.springframework.web.servlet.view.mustache.MustacheViewResolver;

import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.samskivert.mustache.Mustache.TemplateLoader;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages/messages");
		return messageSource;
	}

	@Bean
	public ViewResolver viewResolver(ResourceLoader resourceLoader) {
		MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();
		mustacheViewResolver.setPrefix("/WEB-INF/views/");
		mustacheViewResolver.setSuffix(".html");
	  mustacheViewResolver.setContentType("text/html;charset=utf-8");
	  
	  MustacheTemplateLoader mustacheTemplateLoader = new MustacheTemplateLoader();
		mustacheTemplateLoader.setResourceLoader(resourceLoader);
		
		mustacheViewResolver.setTemplateLoader(mustacheTemplateLoader);
		return mustacheViewResolver;
	}

//
//	@Bean
//	public TemplateResolver templateResolver() {
//		TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setPrefix("/views/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("HTML5");
//		return templateResolver;
//	}
}
