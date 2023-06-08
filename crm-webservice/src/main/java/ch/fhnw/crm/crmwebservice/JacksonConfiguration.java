package ch.fhnw.crm.crmwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Register the JavaTimeModule
        objectMapper.registerModule(new JavaTimeModule());

        // Register the custom module for LocalDate serialization/deserialization
        objectMapper.registerModule(new CustomJsonModule());

        return objectMapper;
    }

    private static class CustomJsonModule extends SimpleModule {
        public CustomJsonModule() {
            super();
            addSerializer(LocalDate.class, new ToStringSerializer());
            addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }
}

   
