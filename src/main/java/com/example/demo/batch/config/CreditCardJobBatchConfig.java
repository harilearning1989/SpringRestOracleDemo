package com.example.demo.batch.config;

import com.example.demo.batch.listen.credit.CreditCardIItemReaderListener;
import com.example.demo.batch.listen.credit.CreditCardIItemWriterListener;
import com.example.demo.batch.listen.credit.CreditCardItemProcessListener;
import com.example.demo.batch.listen.credit.CreditCardJobExecutionListener;
import com.example.demo.batch.process.CreditCardItemProcessor;
import com.example.demo.batch.read.CreditCardItemReader;
import com.example.demo.batch.write.CreditCardItemWriter;
import com.example.demo.entity.CreditCard;
import com.example.demo.entity.CreditCardRisk;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
/*
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing*/
public class CreditCardJobBatchConfig extends DefaultBatchConfigurer {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public CreditCardItemReader reader() {
        return new CreditCardItemReader();
    }

    @Bean
    public CreditCardItemProcessor processor() {
        return new CreditCardItemProcessor();
    }

    @Bean
    public CreditCardItemWriter writer() {
        return new CreditCardItemWriter();
    }

    @Bean
    public CreditCardJobExecutionListener jobExecutionListener() {
        return new CreditCardJobExecutionListener();
    }

    @Bean
    public CreditCardIItemReaderListener readerListener() {
        return new CreditCardIItemReaderListener();
    }

    @Bean
    public CreditCardItemProcessListener creditCardItemProcessListener() {
        return new CreditCardItemProcessListener();
    }

    @Bean
    public CreditCardIItemWriterListener writerListener() {
        return new CreditCardIItemWriterListener();
    }

    @Bean
    public Job job(Step step, CreditCardJobExecutionListener jobExecutionListener) {
        Job job = jobBuilderFactory.get("job1")
                .listener(jobExecutionListener)
                .flow(step)
                .end()
                .build();
        return job;
    }

    @Bean
    public Step step(CreditCardItemReader reader,
                     CreditCardItemWriter writer,
                     CreditCardItemProcessor processor,
                     CreditCardIItemReaderListener readerListener,
                     CreditCardItemProcessListener creditCardItemProcessListener,
                     CreditCardIItemWriterListener writerListener) {

        TaskletStep step = stepBuilderFactory.get("step1")
                .<CreditCard, CreditCardRisk>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(readerListener)
                .listener(creditCardItemProcessListener)
                .listener(writerListener)
                .build();
        return step;
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }

}
