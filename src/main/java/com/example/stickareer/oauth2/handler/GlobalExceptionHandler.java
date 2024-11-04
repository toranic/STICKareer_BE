package com.example.stickareer.oauth2.handler;

import com.example.stickareer.oauth2.exception.TokenErrorResult;
import com.example.stickareer.oauth2.exception.TokenException;
import com.example.stickareer.oauth2.exception.UserErrorResult;
import com.example.stickareer.oauth2.exception.UserException;
import com.example.stickareer.oauth2.ApiResponse;
import com.example.stickareer.oauth2.BaseErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<ApiResponse<BaseErrorCode>> handleTokenException(TokenException e) {
        TokenErrorResult errorResult = e.getTokenErrorResult();
        return ApiResponse.onFailure(errorResult);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiResponse<BaseErrorCode>> handleUserException(UserException e) {
        UserErrorResult errorResult = e.getUserErrorResult();
        return ApiResponse.onFailure(errorResult);
    }
}