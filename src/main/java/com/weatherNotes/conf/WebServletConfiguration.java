package com.weatherNotes.conf;

import com.weatherNotes.conf.ApplicationConfig;
import com.weatherNotes.utils.LogUtil;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext ctx) throws ServletException {

        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
      
        webCtx.register(ApplicationConfig.class);
        ctx.addListener(new RequestContextListener());
        webCtx.setServletContext(ctx);
        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        servlet.setInitParameter("contextClass", webCtx.getClass().getName());

        ctx.addListener(new ContextLoaderListener(webCtx));
        LogUtil.initialize();
        EnumSet dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC);
        FilterRegistration.Dynamic registration = ctx.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);

        registration.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
    }

}
