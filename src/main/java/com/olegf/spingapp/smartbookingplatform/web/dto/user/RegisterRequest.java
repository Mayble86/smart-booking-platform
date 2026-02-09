package com.olegf.spingapp.smartbookingplatform.web.dto.user;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}
