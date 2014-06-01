package tiluws.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

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

//    @Bean
//    @Autowired
//    /**
//     * 
//     * @param resource
//     * @return
//     */
//   public DefaultWsdl11Definition accountDetailsService() throws IOException{
//    	DefaultWsdl11Definition accountDetailsService = new DefaultWsdl11Definition();
//    	CommonsXsdSchemaCollection schemaCollection = new CommonsXsdSchemaCollection();
//    	schemaCollection.setInline(true);
//    	org.springframework.core.io.ClassPathResource resource = 
//    			new ClassPathResource("schemas/AccountDetailsServiceOperations.xsd");
//    	//resource.createRelative;
//    	Collection<org.springframework.core.io.Resource> resourceList=
//    			new LinkedList<org.springframework.core.io.Resource>();
//    	resourceList.add(resource);
//    	schemaCollection.setXsds(resourceList.toArray(new org.springframework.core.io.ClassPathResource[resourceList.size()]  ));
//    	accountDetailsService.setSchemaCollection(schemaCollection);
//    	accountDetailsService.setPortTypeName("AccountDetailsService");
//    	accountDetailsService.setServiceName("AccountDetailsService");     	//AccountDetailsServices??
//    	accountDetailsService.setTargetNamespace("http://webservices.tilufwlow/accountservice");
//    	accountDetailsService.setLocationUri("/webservices");
//   
//
//    	
//	   return accountDetailsService;
//   }
}
