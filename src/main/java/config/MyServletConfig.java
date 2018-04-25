package config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// Servlet的使用
public class MyServletConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
       ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", TestServlet.class);
        myServlet.addMapping("/servlet");
    }
}
