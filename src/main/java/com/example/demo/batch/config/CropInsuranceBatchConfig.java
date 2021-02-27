package com.example.demo.batch.config;

import com.example.demo.batch.exception.FileVerificationSkipper;
import com.example.demo.batch.listen.CropInsuranceJobListener;
import com.example.demo.batch.process.CropInsuranceProcessor;
import com.example.demo.batch.read.CropInsuranceReader;
import com.example.demo.batch.write.CropInsuranceWriter;
import com.example.demo.dto.CropInsuranceDTO;
import com.example.demo.entity.CropInsurance;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;

/*@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing*/
public class CropInsuranceBatchConfig extends DefaultBatchConfigurer {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CropInsuranceWriter cropInsuranceWriter;

    @Autowired
    private CropInsuranceProcessor cropInsuranceProcessor;

    @Bean
    public Job importUserJob(CropInsuranceJobListener listener) {
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
                .<CropInsuranceDTO, CropInsurance>chunk(100)
                .reader(new CropInsuranceReader().reader())
                .faultTolerant()
                .skipPolicy(fileVerificationSkipper())
                .processor(cropInsuranceProcessor)
                .writer(cropInsuranceWriter)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setConcurrencyLimit(5);
        return simpleAsyncTaskExecutor;
    }

    @Bean
    public SkipPolicy fileVerificationSkipper() {
        return new FileVerificationSkipper();
    }

}
