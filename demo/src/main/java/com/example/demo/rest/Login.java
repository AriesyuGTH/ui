package com.example.demo.rest;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    Logger logger = LoggerFactory.getLogger(Login.class);

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        try {
            return Collections.singletonMap("name", principal.getAttribute("name"));
        } catch (Exception e) {
            logger.error("[{}] /user 路徑發生錯誤了，原因是：", ExceptionUtils.getStackTrace(e));
            return Collections.emptyMap();
        }
    }

    @GetMapping("/error")
    public String error(HttpServletRequest request) {
        try {
            String message = (String) request.getSession().getAttribute("error.message");
            request.getSession().removeAttribute("error.message");
            return message;
        } catch (Exception e) {
            logger.error("[{}] /error 路徑發生錯誤了，原因是：", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }
}
