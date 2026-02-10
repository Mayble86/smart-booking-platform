package com.olegf.spingapp.smartbookingplatform.domain.repository;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Booking;
import com.olegf.spingapp.smartbookingplatform.domain.entity.TimeSlot;
import jakarta.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByIsBookedFalseAndStartTimeAfter(LocalDateTime startTime);

    List<TimeSlot> findByServicesIdAndIsBookedFalseAndStartTimeAfter(Long servicesId, LocalDateTime startTime);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT t FROM TimeSlot t WHERE t.id = :id AND t.isBooked = false")
    Optional<TimeSlot> findAvailableForBooking(@Param("id") Long id);
}
