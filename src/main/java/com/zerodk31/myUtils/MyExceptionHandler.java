package com.zerodk31.myUtils;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> customExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> result = new HashMap<>();
        FieldError fieldError = e.getFieldError();

        result.put("errField", fieldError.getField());
        result.put("message", fieldError.getDefaultMessage());
        result.put("value", fieldError.getRejectedValue().toString());

        return result;
    }
}
