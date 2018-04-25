package config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyFilterConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", TestFilter.class);
        // urlPatterns参数设置成"/**/不能拦截任何信息,设置成/*可以拦截项目名后的多个/拼接的路径
        myFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
