package com.olegf.spingapp.smartbookingplatform.domain.service;

import com.olegf.spingapp.smartbookingplatform.domain.entity.AppUser;
import com.olegf.spingapp.smartbookingplatform.domain.entity.Role;
import com.olegf.spingapp.smartbookingplatform.domain.repository.RoleRepo;
import com.olegf.spingapp.smartbookingplatform.domain.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public AppUser register(String email, String password) {
        if (userRepo.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists: " + email);
        }

        AppUser appUser = new AppUser();
        appUser.setEmail(email);
        appUser.setPassword(passwordEncoder.encode(password));

        Role userRole = roleRepo.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Role USER not found"));
        appUser.getRoles().add(userRole);

        return userRepo.save(appUser);
    }
}
