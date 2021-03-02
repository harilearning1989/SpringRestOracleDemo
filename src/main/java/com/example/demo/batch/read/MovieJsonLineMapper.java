package com.example.demo.batch.read;

import com.example.demo.dto.MovieDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.file.LineMapper;

public class MovieJsonLineMapper  implements LineMapper<MovieDTO> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public MovieDTO mapLine(String line, int lineNumber) throws Exception {
        return mapper.readValue(line, MovieDTO.class);
    }
}
