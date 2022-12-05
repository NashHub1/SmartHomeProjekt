package smarthomeapp.security;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import smarthomeapp.Vaadinpackage.LogInView;

import java.util.Collections;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, LogInView.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**");
        super.configure(web);
    }
    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(User.withUsername("nash")
                .password("{noop}user")
                .roles("USER").build());
    }


}




// funktioniert nur mit extends VaadinWebSecurityConfigurerAdapter
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        setLoginView(http, LogInView.class);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/images/**");
//        super.configure(web);
//    }
//
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService(){
//        return new InMemoryUserDetailsManager(User.withUsername("nash")
//                .password("{noop}user")
//                .roles("USER").build());
//    }