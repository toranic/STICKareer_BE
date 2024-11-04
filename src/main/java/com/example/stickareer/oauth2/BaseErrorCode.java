package com.example.stickareer.oauth2;

import com.example.stickareer.oauth2.common.ErrorReasonDto;

public interface BaseErrorCode {
    public ErrorReasonDto getReason();

    public ErrorReasonDto getReasonHttpStatus();
}