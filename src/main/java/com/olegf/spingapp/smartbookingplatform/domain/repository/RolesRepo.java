package com.olegf.spingapp.smartbookingplatform.domain.repository;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Roles;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends CrudRepository<Roles, Long> {
    Optional<Roles> findByName(String name);
}
