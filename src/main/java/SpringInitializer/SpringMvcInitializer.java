package SpringInitializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.proyecto.cero.config.AppConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	//voy a mapear absolutamente TODAS las paginas
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}
