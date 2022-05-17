package com.recruit.recruitms.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
//Builder instead of constructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private LocalDateTime timeStamp;
    private String message;
    private String developerMessage;
}
