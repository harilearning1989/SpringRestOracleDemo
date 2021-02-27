package com.example.demo.batch.config;

import com.example.demo.batch.listen.StudentListener;
import com.example.demo.batch.process.StudentProcessor;
import com.example.demo.batch.read.StudentReader;
import com.example.demo.batch.write.StudentWriter;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
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
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;

/*@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing*/
public class StudentBatchConfig extends DefaultBatchConfigurer {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private StudentWriter studentWriter;

    @Autowired
    private StudentProcessor studentProcessor;

    @Bean
    public Job importUserJob(StudentListener listener) {
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
                .<StudentDTO, Student>chunk(100)
                .reader(new StudentReader().reader())
                .processor(studentProcessor)
                .writer(studentWriter)
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
}

