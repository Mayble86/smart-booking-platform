package com.olegf.spingapp.smartbookingplatform.web.controller;

import com.olegf.spingapp.smartbookingplatform.domain.entity.AppUser;
import com.olegf.spingapp.smartbookingplatform.domain.mapper.AppUserMapper;
import com.olegf.spingapp.smartbookingplatform.domain.service.UserService;
import com.olegf.spingapp.smartbookingplatform.web.dto.user.AppUserResponse;
import com.olegf.spingapp.smartbookingplatform.web.dto.user.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AppUserMapper appUserMapper;

    @PostMapping("/register")
    public ResponseEntity<AppUserResponse> register(@RequestBody @Valid RegisterRequest request) {
        AppUser user = userService.register(request.getEmail(), request.getPassword());

        return ResponseEntity.ok(appUserMapper.toResponse(user));
    }
}
