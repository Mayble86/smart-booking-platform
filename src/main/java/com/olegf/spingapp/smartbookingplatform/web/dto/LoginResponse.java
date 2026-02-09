package com.olegf.spingapp.smartbookingplatform.web.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String message;
}
