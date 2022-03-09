package com.kadowork.springbootbatchdemo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeforeUser {
    private Integer id;
    private String firstName;
    private String lastName;
}
