package com.example.stickareer.oauth2;

import com.example.stickareer.oauth2.common.ReasonDto;

public interface BaseCode {
    public ReasonDto getReason();

    public ReasonDto getReasonHttpStatus();
}