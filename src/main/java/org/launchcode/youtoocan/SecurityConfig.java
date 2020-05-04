package org.launchcode.youtoocan;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/","/resources/**","/css/**","/js/**","/images/**","/fonts/**","/scss/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }

    }
