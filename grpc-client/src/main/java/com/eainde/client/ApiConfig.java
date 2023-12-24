package com.eainde.client;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;

/**
 * Spring’s default decoder does not support format and decode generated objects from proto files.
 * So we can change this decoder by providing Spring a bean called ProtobufJsonFormatHttpMessageConverter.
 */
@Data
@Configuration
public class ApiConfig {
    @Bean
    public ProtobufJsonFormatHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufJsonFormatHttpMessageConverter();
    }
}
