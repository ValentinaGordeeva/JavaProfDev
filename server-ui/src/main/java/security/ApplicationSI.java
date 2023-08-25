package security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({"security", "config"})
public class ApplicationSI {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(ApplicationSI.class, args);
    }
}
