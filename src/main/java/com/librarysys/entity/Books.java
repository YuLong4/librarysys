package com.librarysys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private String isbn;
    private String title;
    private String pubname;
    private String author;
    private BigDecimal authorno;
    private BigDecimal zncode;
}
