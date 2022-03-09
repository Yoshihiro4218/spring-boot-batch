package com.kadowork.springbootbatchdemo;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.*;
import org.springframework.batch.item.file.*;
import org.springframework.batch.item.file.builder.*;
import org.springframework.batch.item.file.mapping.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
@Slf4j
public class BatchConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        log.info("Job !!");
        return jobBuilderFactory
                .get("testJob")
                .incrementer(new RunIdIncrementer())
                .start(chunkStep())
                .build();
    }

    @Bean
    public Step chunkStep() {
        log.info("Chunk !!");
        return stepBuilderFactory.get("step1")
                                 .<BeforeUser, AfterUser>chunk(10)
                                 .reader(chunkReader())
                                 .processor(chunkProcessor())
                                 .writer(chunkWriter())
                                 .build();
    }

    @Bean
    public FlatFileItemReader<BeforeUser> chunkReader() {
        log.info("ChunkReader !!");
        return new FlatFileItemReaderBuilder<BeforeUser>()
                .name("beforeUserCSV")
                .resource(new ClassPathResource("beforeUser.csv"))
                .delimited().names(new String[]{"id", "firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {
                    {
                        setTargetType(BeforeUser.class);
                    }
                }).build();
    }

    @Bean
    public UserItemProcessor chunkProcessor() {
        log.info("ChunkProcessor !!");
        return new UserItemProcessor();
    }

    @Bean
    public UserItemWriter chunkWriter() {
        log.info("ChunkWriter !!");
        return new UserItemWriter();
    }
}
