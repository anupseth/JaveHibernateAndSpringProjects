package anup.Spmvc.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ViewConfiguration {

	public final ApplicationContext appContext;
	
	public ViewConfiguration(ApplicationContext appContext) {
		this.appContext = appContext;
	}
	
	
	@Bean
	public ITemplateResolver tempREsolver() {
		SpringResourceTemplateResolver tempResolver = new SpringResourceTemplateResolver();
		tempResolver.setApplicationContext(appContext);
		tempResolver.setPrefix("classpath:/templates/");
		tempResolver.setSuffix(".html");
		tempResolver.setTemplateMode("HTML");
		tempResolver.setCharacterEncoding("UTF-8");
		return tempResolver;
	}
	
	@Bean
	public SpringTemplateEngine tempEngine() {
		SpringTemplateEngine sptempEng = new SpringTemplateEngine();
		sptempEng.setEnableSpringELCompiler(true);
		sptempEng.setTemplateResolver(tempREsolver());
		return sptempEng;
		
	}
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(tempEngine());
		return viewResolver;
	}
}
