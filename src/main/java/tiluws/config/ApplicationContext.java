package tiluws.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"tiluws.service","tiluws.endpoint"})
@EnableTransactionManagement
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:application.properties")
public class ApplicationContext {
    @Resource
    private Environment environment;
    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/";
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
        viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);

        return viewResolver;
    }    
}
