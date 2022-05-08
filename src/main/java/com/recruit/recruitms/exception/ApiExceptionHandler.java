package com.recruit.recruitms.exception;

import com.recruit.recruitms.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Response> handleApiRequestException(ApiRequestException ex){
        return new ResponseEntity<>(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .reason(ex.getMessage())
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }
}
