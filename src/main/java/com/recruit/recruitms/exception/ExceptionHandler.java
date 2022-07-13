package com.recruit.recruitms.exception;

import com.recruit.recruitms.dto.response.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler {
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ApiRequestException.class})
//    public ResponseEntity<ErrorMessage> handleApiRequestException(ApiRequestException ex){
//        return new ResponseEntity<>(
//                ErrorMessage.builder()
//                        .timeStamp(LocalDateTime.now())
//                        .message(ex.getMessage())
//                        .build(),
//                HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<ErrorMessage> handleException(Exception ex){
//        return new ResponseEntity<>(
//                ErrorMessage.builder()
//                        .timeStamp(LocalDateTime.now())
//                        .message(ex.getMessage())
//                        .build(),
//                HttpStatus.EXPECTATION_FAILED);
//    }

}
