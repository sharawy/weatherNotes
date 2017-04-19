package com.weatherNotes.conf.security;

import com.weatherNotes.common.Defines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//

    @Autowired
    NormalAuthenticationProvider normalAuthenticationProvider;

    @Autowired
    private ConfigurableEnvironment env;

    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().xssProtection();

        http.addFilterBefore(new LoginAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.authenticationProvider(normalAuthenticationProvider);

        http.authorizeRequests()
                .antMatchers("/").access("hasAnyRole('" + Defines.UserRoles.USER + "','" + Defines.UserRoles.ADMIN + "')")
                .antMatchers("/systemNotes**").access("hasRole('" + Defines.UserRoles.ADMIN + "')")
                .antMatchers("/preNotes**").access("hasRole('" + Defines.UserRoles.ADMIN + "')")
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/j_spring_security_logout").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/Performlogin")
                .permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().exceptionHandling()
                .and().httpBasic()
                .and()
                .logout().logoutUrl("/j_spring_security_logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID").permitAll()
                .and()
                .csrf().csrfTokenRepository(csrfTokenRepository())
                .and()
                .sessionManagement()
                .sessionFixation()
                .migrateSession()
                .maximumSessions(1);

    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}
