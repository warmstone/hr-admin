package com.warmstone.hr.config;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author warmstone
 * @date 2023/11/8 20:24
 * @description
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final AuthenticationSuccessHandler loginSuccessHandler;

    private final AuthenticationFailureHandler loginFailureHandler;

    private final FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    private final AccessDecisionManager accessDecisionManager;

    private final AccessDeniedHandler accessDeniedHandler;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .formLogin()
                .loginProcessingUrl("/admin/login")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(accessDecisionManager);
                        object.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                .and()
                .sessionManagement()
                // 不创建session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 拦截请求
                .antMatchers("/admin/**").authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui/", "/swagger**/**", "/swagger-resources/**").permitAll()
                .and()
                // 关闭csrf
                .csrf().disable();
        return httpSecurity.build();
    }
}
