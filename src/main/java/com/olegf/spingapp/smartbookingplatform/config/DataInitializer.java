package com.olegf.spingapp.smartbookingplatform.config;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Roles;
import com.olegf.spingapp.smartbookingplatform.domain.repository.RolesRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final RolesRepo rolesRepo;

    public DataInitializer(RolesRepo rolesRepo) {
        this.rolesRepo = rolesRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (rolesRepo.count() == 0) {
            System.out.println("Creating roles");

            Roles userRole = new Roles("USER", "User");
            Roles adminRole = new Roles("ADMIN", "Admin");

            rolesRepo.save(userRole);
            rolesRepo.save(adminRole);

            System.out.println("Roles created");
        } else {
            System.out.println("Roles already exists");
        }
    }
}
