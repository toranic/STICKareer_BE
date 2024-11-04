package com.example.stickareer.oauth2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;
import jakarta.servlet.ServletException;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {
        // OAuth2 인증 성공 후 처리 로직
        setDefaultTargetUrl("/");  // 인증 성공 후 리다이렉트할 기본 URL
        super.onAuthenticationSuccess(request, response, authentication);
    }
} 