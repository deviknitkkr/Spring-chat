package com.devik.webchat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.PortMapper;
import org.springframework.security.web.PortMapperImpl;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Value("${server.port}")
//    private int serverPort;
//
//    @Value("${security.sslRedirectPort}")
//    private int sslRedirectPort;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user-1").password("{noop}1234").authorities("ADMIN").and()
                .withUser("user-2").password("{noop}1234").authorities("MANAGER").and()
                .withUser("user-3").password("{noop}1234").authorities("MANAGER");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.requestCache().requestCache(requestCache());
//    }
//
//    private PortMapper portMapper() {
//        PortMapperImpl portMapper = new PortMapperImpl();
//        Map<String, String> mappings = new HashMap<>();
//        mappings.put(Integer.toString(serverPort), Integer.toString(sslRedirectPort));
//        portMapper.setPortMappings(mappings);
//        return portMapper;
//    }
//
//    private RequestCache requestCache() {
//        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
//        PortResolverImpl portResolver = new PortResolverImpl();
//        portResolver.setPortMapper(portMapper());
//        requestCache.setPortResolver(portResolver);
//        return requestCache;
//    }
}
