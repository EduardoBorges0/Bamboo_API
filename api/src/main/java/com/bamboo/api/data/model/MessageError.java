package com.bamboo.api.data.model;

import lombok.Data;

@Data
public class MessageError {
    private String message;
    private Integer code;
}
