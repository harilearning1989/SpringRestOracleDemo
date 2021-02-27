package com.example.demo.batch.read;

import com.example.demo.dto.CreditCardDTO;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class CreditCardReader extends FlatFileItemReader<CreditCardDTO> {

    @Bean
    public FlatFileItemReader<CreditCardDTO> reader() {
        FlatFileItemReader<CreditCardDTO> reader = new FlatFileItemReader<CreditCardDTO>();
        reader.setResource(new ClassPathResource("DataFiles/500000CCRecords.csv"));

        reader.setLineMapper(new DefaultLineMapper<CreditCardDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"Card Type Code", "Card Type Full Name", "Issuing Bank", "Card Number", "Card Holder's Name",
                        "CVV/CVV2", "Issue Date", "Expiry Date",
                        "Billing Date", "Card PIN", "Credit Limit"});
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(CreditCardDTO.class);
            }});

        }});
        reader.setLinesToSkip(1);
        return reader;
    }
}
