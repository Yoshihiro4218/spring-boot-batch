package com.kadowork.springbootbatchdemo;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.*;
import org.springframework.batch.item.file.*;
import org.springframework.batch.item.file.mapping.*;
import org.springframework.batch.item.file.transform.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
@Slf4j
public class AddressBatchConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private static final String CSV_FILE_PATH = "zenkoku.csv";

    // chunk
    @Bean
    public Job addressChunkJob() {
        return jobBuilderFactory
                .get("addressChunkJob")
                .incrementer(new RunIdIncrementer())
                .start(addressChunkStep())
                .build();
    }

    @Bean
    public Step addressChunkStep() {
        return stepBuilderFactory.get("step1")
                                 .<Address, Address>chunk(2500)
                                 .reader(addressChunkReader())
                                 .processor(addressChunkProcessor())
                                 .writer(addressChunkWriter())
                                 .build();
    }

    @Bean
    public FlatFileItemReader<Address> addressChunkReader() {
        log.info("====== Read Address ======");
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "prefCd", "cityCd", "townCd", "zip", "officeFlg", "deleteFlg",
                               "prefName", "prefKana", "cityName", "cityKana", "townName", "townKana",
                               "townMemo", "kyotoStreet", "azaName", "azaKana", "memo", "officeName",
                               "officeKana", "officeAddress", "newId");

        BeanWrapperFieldSetMapper<Address> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Address.class);

        DefaultLineMapper<Address> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        FlatFileItemReader<Address> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource(CSV_FILE_PATH));
        reader.setLinesToSkip(1);
        reader.setEncoding("Shift_JIS");
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public AddressItemProcessor addressChunkProcessor() {
        return new AddressItemProcessor();
    }

    @Bean
    public AddressItemWriter addressChunkWriter() {
        return new AddressItemWriter();
    }
}
