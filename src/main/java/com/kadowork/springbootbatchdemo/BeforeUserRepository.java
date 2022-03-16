package com.kadowork.springbootbatchdemo;

import lombok.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
@AllArgsConstructor
public class BeforeUserRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<BeforeUser> MAPPER = new BeanPropertyRowMapper<>(BeforeUser.class);

    public List<BeforeUser> selectAll() {
        return jdbcTemplate.query("SELECT * FROM before_user;", MAPPER);
    }
}
