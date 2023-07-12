package kr.co.spatialt.rdatgis.boot.config;

import kr.co.spatialt.rdatgis.RdaTgisApplication;
import kr.co.spatialt.rdatgis.cmm.interceptor.RdaTgisInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import({
        EgovConfigAspect.class,
        EgovConfigCommon.class,
    	EgovConfigIdGeneration.class,
        EgovConfigProperties.class,
        EgovConfigTransaction.class,
        EgovConfigValidator.class,
        DataSourceConfig.class
})
public class EgovConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RdaTgisInterceptor())
				.excludePathPatterns("/css/**", "/images/**", "/js/**");
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**")
//				.addResourceLocations("classpath:/templates")
//	}
}
