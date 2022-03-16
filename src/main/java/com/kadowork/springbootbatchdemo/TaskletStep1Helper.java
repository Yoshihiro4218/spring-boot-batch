package com.kadowork.springbootbatchdemo;

import lombok.*;
import org.springframework.batch.core.*;
import org.springframework.batch.core.scope.context.*;
import org.springframework.batch.core.step.tasklet.*;
import org.springframework.batch.repeat.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@AllArgsConstructor
public class TaskletStep1Helper implements Tasklet {
    private final BeforeUserRepository beforeUserRepository;
    private final AfterUserRepository afterUserRepository;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<BeforeUser> beforeUser = beforeUserRepository.selectAll();
        beforeUser.forEach(x -> afterUserRepository.create(AfterUser.builder()
                                                                    .name(x.getLastName() + " " + x.getFirstName())
                                                                    .build()));
        return RepeatStatus.FINISHED;
    }
}
