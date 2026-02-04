package com.olegf.spingapp.smartbookingplatform.domain.repository;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Role;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
