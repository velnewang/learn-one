package win.velne.learnone.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() //
                .withUser("user").password("user").roles("USER") //
                .and() //
                .withUser("admin").password("admin").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        // return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin() //
                .loginPage("/login") //
                .loginProcessingUrl("/authenticate");
        httpSecurity.authorizeRequests() //
                .antMatchers("/login").permitAll() //
                .antMatchers("/user").hasAnyRole("USER", "ADMIN") //
                .antMatchers("/admin").hasRole("ADMIN") //
                .anyRequest().authenticated();
        httpSecurity.csrf().disable();
    }
}
