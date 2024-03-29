package com.morj.visitscount.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response {
    private String method;
    private String description;
    private String value;
}
