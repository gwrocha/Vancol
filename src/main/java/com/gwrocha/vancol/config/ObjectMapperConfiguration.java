package com.gwrocha.vancol.config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

@Configuration
public class ObjectMapperConfiguration {
	
	@Bean
	public Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.serializationInclusion(JsonInclude.Include.NON_NULL);
	    builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
	    builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	    builder.serializers(new LocalTimeSerializer(DateTimeFormatter.ofPattern("HHmm")));
	    builder.deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	    builder.deserializers(new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HHmm")));
	    return builder;
	}
	
}
