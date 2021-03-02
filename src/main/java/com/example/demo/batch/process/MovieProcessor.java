package com.example.demo.batch.process;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.MovieGenre;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MovieProcessor implements ItemProcessor<MovieDTO, MovieGenre> {

    @Override
    public MovieGenre process(final MovieDTO dto) throws Exception {
        final MovieGenre empDto = new MovieGenre(dto.getTitle(), dto.getGenres().toString());
        return empDto;
    }
}
