package com.kadowork.springbootbatchdemo;

import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class UserItemWriter implements ItemWriter<AfterUser> {
    @Autowired
    private AfterUserRepository afterUserRepository;

    @Override
    public void write(List<? extends AfterUser> list) throws Exception {
        list.forEach(afterUserRepository::create);
    }
}
