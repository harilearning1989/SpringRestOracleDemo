package com.example.demo.batch.read;

import com.example.demo.dto.MovieDTO;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class MovieReader extends FlatFileItemReader<MovieDTO> {
    /*@Bean
    public JsonItemReader jsonItemReader() {
        JsonItemReader builder = null;
        try {
            builder = new JsonItemReaderBuilder()
                    .jsonObjectReader(new JacksonJsonObjectReader(MovieDTO.class))
                    //.resource(new UrlResource("https://raw.github.com/master/movies.json"))
                    .resource(new ClassPathResource("json/movie.json"))
                    .name("movieJsonItemReader")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder;
    }
*/
    @Bean
    public FlatFileItemReader<MovieDTO> jsonItemReader() {
        FlatFileItemReader<MovieDTO> reader = new FlatFileItemReader<>();

        reader.setResource(new ClassPathResource("json/movie.json"));

        MovieJsonLineMapper lineMapper = new MovieJsonLineMapper();

        reader.setLineMapper(lineMapper);

        return reader;
    }

}
