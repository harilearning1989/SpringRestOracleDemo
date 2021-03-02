package com.example.demo.batch.write;

import com.example.demo.dto.MovieGenre;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieWriter implements ItemWriter<MovieGenre> {

    @Override
    public void write(List<? extends MovieGenre> movies) throws Exception {
        movies.forEach(m -> System.out.println(m.getTitle()));
    }
}