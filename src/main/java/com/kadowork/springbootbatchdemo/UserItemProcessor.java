package com.kadowork.springbootbatchdemo;

import lombok.extern.slf4j.*;
import org.springframework.batch.item.*;

@Slf4j
public class UserItemProcessor implements ItemProcessor<BeforeUser, AfterUser> {
    @Override
    public AfterUser process(BeforeUser beforeUser) {
        AfterUser afterUser =
                AfterUser.builder()
                         .id(beforeUser.getId())
                         .name(beforeUser.getLastName() +
                               " " +
                               beforeUser.getFirstName())
                         .build();
        log.info("AfterUserName: {}", afterUser);
        return afterUser;
    }
}
