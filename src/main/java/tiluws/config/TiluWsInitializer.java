package tiluws.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;




import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

/**
 * Uses the standard WS Initializer
 * Requires servlet 3.0 and spring 3.1 or superior
 * @author eidos71
 *
 */
public class TiluWsInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING = "/mvc/*";
    private static final String DISPATCHER_SERVLET_WS="spring-ws";
    private static final String DISPATCHER_SERVLET_WS_MAPPING="/webservices/*";
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationContext.class);

        ServletRegistration.Dynamic ws_dispatcher=
        		servletContext.addServlet(DISPATCHER_SERVLET_WS, new MessageDispatcherServlet(rootContext));
        ws_dispatcher.setLoadOnStartup(1); 
        ws_dispatcher.addMapping(DISPATCHER_SERVLET_WS_MAPPING);
        ws_dispatcher.setInitParameter("transformWsdlLocations", "true");
        ServletRegistration.Dynamic dispatcher = 
        		servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);

        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

}
