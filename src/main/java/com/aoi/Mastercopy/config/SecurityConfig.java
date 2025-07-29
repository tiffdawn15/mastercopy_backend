//package com.aoi.Mastercopy.config;
//
//import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${auth0.audience}")
//    private String audience;
//
//    @Value("${auth0.issuer}")
//    private String issuer;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        JwtWebSecurityConfigurer
//                .forRS256(audience, issuer)
//                .configure(http)
//                .authorizeRequests()
//                .antMatchers("/api/collections/**").authenticated()
//                .anyRequest().permitAll();
//    }
//}