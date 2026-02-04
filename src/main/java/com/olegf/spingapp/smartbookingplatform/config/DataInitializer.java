package com.olegf.spingapp.smartbookingplatform.config;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Role;
import com.olegf.spingapp.smartbookingplatform.domain.repository.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final RoleRepo roleRepo;

    public DataInitializer(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepo.count() == 0) {
            System.out.println("Creating roles");

            Role userRole = new Role("USER", "User");
            Role adminRole = new Role("ADMIN", "Admin");

            roleRepo.save(userRole);
            roleRepo.save(adminRole);

            System.out.println("Roles created");
        } else {
            System.out.println("Roles already exists");
        }
    }
}
