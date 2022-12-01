package com.librarysys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private int id;
    private String name;
    private String address;
    private Integer gender;
    private int age;
}
