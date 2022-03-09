package com.kadowork.springbootbatchdemo;

import lombok.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
@AllArgsConstructor
public class BeforeUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<BeforeUser> selectAll() {
        return jdbcTemplate.queryForList(
                "SELECT * FROM before_user;", BeforeUser.class);
    }
}
