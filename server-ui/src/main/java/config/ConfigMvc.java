package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ConfigMvc extends WebMvcConfigurerAdapter {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/routes").setViewName("routes");
        registry.addViewController("/payments").setViewName("payments");
        registry.addViewController("/registerClient").setViewName("registerClient");
        registry.addViewController("/registerManager").setViewName("registerManager");
        registry.addViewController("/home").setViewName("home");
         registry.addViewController("/css/file.css").setViewName("/css/file.css");
        //registry.addViewController("/img/img.jpg").setViewName("/img/img.jpg");
        registry.addViewController("/login").setViewName("login");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/templates/img/");

    }
}
