package com.kadowork.springbootbatchdemo;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

@Repository
@AllArgsConstructor
@Slf4j
public class AfterUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public void create(AfterUser afterUser) {
        log.info("AfterUser: {}", afterUser.getName());
        jdbcTemplate.update("INSERT INTO after_user SET name = ?;",
                            afterUser.getName());
    }
}
