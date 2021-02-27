package com.example.demo.batch.read;

import com.example.demo.dto.CountriesDTO;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class CountriesReader extends JsonItemReader<CountriesDTO> {

    @Bean
    public JsonItemReader itemReader() {
        return new JsonItemReaderBuilder<>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(CountriesDTO.class))
                .resource(new ClassPathResource("json/Countries.json"))
                .name("movieJsonItemReader")
                .build();
    }


}
