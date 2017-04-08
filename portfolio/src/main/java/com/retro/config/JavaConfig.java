package com.retro.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.retro.PortfolioApplication;
import com.retro.rest.intercepter.LoggingRequestInterceptor;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
@Configuration
@ComponentScan(basePackageClasses=PortfolioApplication.class)
public class JavaConfig {


    @Bean
    public RestOperations restOperations(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new LoggingRequestInterceptor());
        restTemplate.setInterceptors(interceptors);
        MappingJackson2HttpMessageConverter e = new MappingJackson2HttpMessageConverter();
        e.setSupportedMediaTypes(Arrays.asList(new MediaType[]{MediaType.TEXT_HTML}));
        e.getObjectMapper().configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        restTemplate.getMessageConverters().add(e);
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(@Value("${connect.timeout}") int connectTimeout,
            @Value("${read.timeout}") int readTimeout) {
        HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(connectTimeout);
        factory.setReadTimeout(readTimeout);
        return factory;
    }

}
