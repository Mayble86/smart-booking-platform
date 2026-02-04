package com.olegf.spingapp.smartbookingplatform.domain.repository;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Booking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByClientId(Long clientId);
}
