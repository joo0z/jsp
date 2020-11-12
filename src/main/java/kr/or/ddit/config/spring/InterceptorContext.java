package kr.or.ddit.config.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.member.web.profileDownloadView;
import kr.or.ddit.mvc.intercepter.PerformanceCheckInterceptor;
import kr.or.ddit.mvc.intercepter.SessionCheckIntercepter;
import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;

//<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
//<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
//<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
//</context:component-scan>
//@Configuration
//<mvc:annotation-driven/>
@EnableWebMvc
public class InterceptorContext extends WebMvcConfigurerAdapter{
	
//	<!-- 	intercepter 설정 -->
//	<!-- 	<mvc:interceptors> -->
//	<!-- 		<mvc:interceptor> -->
//	<!-- 			<mvc:mapping path="/**"/> -->
//	<!-- 			<bean class="kr.or.ddit.mvc.intercepter.PerformanceCheckInterceptor"></bean> -->
//	<!-- 		</mvc:interceptor> -->
	
//	<!-- 		<mvc:interceptor> -->
//	<!-- 			<mvc:mapping path="/**"/> -->
//	<!-- 			<mvc:exclude-mapping path="/login/*"/> -->
//	<!-- 			<mvc:exclude-mapping path="/js/*"/> -->
//	<!-- 			<mvc:exclude-mapping path="/css/*"/> -->
//	<!-- 			<mvc:exclude-mapping path="/resources/*"/> -->
//	<!-- 			<bean class="kr.or.ddit.mvc.intercepter.SessionCheckIntercepter"></bean> -->
//	<!-- 		</mvc:interceptor> -->
//	<!-- 	</mvc:interceptors> -->erceptors>
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new PerformanceCheckInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new SessionCheckIntercepter()).addPathPatterns("/**")
									.excludePathPatterns("/login/*","/js/*","/css/*","/resources/*"); // 제외할 패턴
		
	}
	
	
	
	
}
