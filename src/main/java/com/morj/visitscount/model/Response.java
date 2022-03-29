package com.morj.visitscount.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response {
    private String requestMethod;
    private String description;
    private long count;
}
