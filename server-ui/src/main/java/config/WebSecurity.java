package config;

import org.apache.catalina.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/css/file.css", "/img/img.jpg").permitAll()
                    .antMatchers("/routes", "/payments").hasAnyRole("CLIENT", "MANAGER", "ROOT")
                    .antMatchers("/registerClient").hasAnyRole("MANAGER", "ROOT")
                    .antMatchers("/registerManager").hasRole("ROOT")
                    .antMatchers("/","/home").authenticated()
                    .anyRequest().access("hasRole('CLIENT') or hasRole('MANAGER') or hasRole('ROOT')")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home",true)
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("client").password("1234").roles("CLIENT")
                .and()
                .withUser("manager").password("5678").roles("MANAGER")
                .and()
                .withUser("root").password("2345").roles("ROOT");
    }



}
