package com.example.demo.batch.config;

import com.example.demo.batch.listen.SaleDetailJobListener;
import com.example.demo.batch.process.SalesDetailProcessor;
import com.example.demo.batch.write.SalesOrderWriter;
import com.example.demo.dto.SalesOrderDTO;
import com.example.demo.entity.SalesOrder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing*/
public class SalesDetailBatchConfig extends DefaultBatchConfigurer {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SalesOrderWriter salesOrderWriter;

    @Autowired
    private SalesDetailProcessor salesDetailProcessor;

    @Bean
    public Job importUserJob(SaleDetailJobListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<SalesOrderDTO, SalesOrder>chunk(100)
                .processor(salesDetailProcessor)
                .writer(salesOrderWriter)
                .build();
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }

}

