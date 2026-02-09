package com.olegf.spingapp.smartbookingplatform.web.dto.user;

import java.util.Set;
import lombok.Data;

@Data
public class AppUserDto {
    private Long id;
    private String email;
    private Set<String> roles;
}