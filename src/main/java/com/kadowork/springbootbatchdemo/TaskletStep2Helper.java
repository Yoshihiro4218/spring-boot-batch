package com.kadowork.springbootbatchdemo;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.batch.core.*;
import org.springframework.batch.core.scope.context.*;
import org.springframework.batch.core.step.tasklet.*;
import org.springframework.batch.repeat.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class TaskletStep2Helper implements Tasklet {
    private final BeforeUserRepository beforeUserRepository;
    private final AfterUserRepository afterUserRepository;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("==============================");
        log.info("This is TaskletStep2Helper !!");
        log.info("==============================");
        return RepeatStatus.FINISHED;
    }
}
