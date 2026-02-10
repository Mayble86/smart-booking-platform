package com.olegf.spingapp.smartbookingplatform.domain.repository;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Serve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServeRepo extends JpaRepository<Serve, Long> {
}
