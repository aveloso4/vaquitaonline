package SpringInitializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

import com.proyecto.cero.config.AppConfig;
import com.proyecto.cero.config.SecurityConfig;
import com.proyecto.cero.config.SocialConfig;
import com.proyecto.cero.config.WebMvcConfig;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class, WebMvcConfig.class, SecurityConfig.class, SocialConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		
		DelegatingFilterProxy reconnectDelegate = new DelegatingFilterProxy("apiExceptionHandler");
		
		return new Filter[] { reconnectDelegate, encodingFilter, new HiddenHttpMethodFilter() };
	}

}
