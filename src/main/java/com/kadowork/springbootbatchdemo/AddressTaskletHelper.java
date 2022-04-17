package com.kadowork.springbootbatchdemo;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.batch.core.*;
import org.springframework.batch.core.scope.context.*;
import org.springframework.batch.core.step.tasklet.*;
import org.springframework.batch.repeat.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class AddressTaskletHelper implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<AddressForTasklet> addresses = readAddressCsv();
        log.info(String.valueOf(addresses.get(0)));
        return RepeatStatus.FINISHED;
    }

    private List<AddressForTasklet> readAddressCsv() throws IOException {
        CsvMapper csvMapper = new CsvMapper();

        CsvSchema csvSchema = csvMapper
                .schemaFor(AddressForTasklet.class)
                .withHeader();
        List<AddressForTasklet> result = new ArrayList<>();

        MappingIterator<AddressForTasklet> objectMappingIterator =
                csvMapper.readerFor(AddressForTasklet.class)
                         .with(csvSchema)
                         .readValues(Paths.get("src/main/resources/zenkoku_utf8.csv").toFile());

        while (objectMappingIterator.hasNext()) {
            result.add(objectMappingIterator.next());
        }
        return result;
    }
}
