package com.example.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
