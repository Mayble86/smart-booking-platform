package com.olegf.spingapp.smartbookingplatform.domain.repository;

import com.olegf.spingapp.smartbookingplatform.domain.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
