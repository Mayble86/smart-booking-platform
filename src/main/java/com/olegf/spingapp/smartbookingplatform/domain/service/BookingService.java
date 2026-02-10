package com.olegf.spingapp.smartbookingplatform.domain.service;

import com.olegf.spingapp.smartbookingplatform.domain.entity.AppUser;
import com.olegf.spingapp.smartbookingplatform.domain.entity.Booking;
import com.olegf.spingapp.smartbookingplatform.domain.entity.BookingStatus;
import com.olegf.spingapp.smartbookingplatform.domain.entity.TimeSlot;
import com.olegf.spingapp.smartbookingplatform.domain.mapper.BookingMapper;
import com.olegf.spingapp.smartbookingplatform.domain.repository.BookingRepo;
import com.olegf.spingapp.smartbookingplatform.domain.repository.TimeSlotRepo;
import com.olegf.spingapp.smartbookingplatform.web.dto.booking.BookingResponse;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepo bookingRepo;
    private final TimeSlotRepo timeSlotRepo;
    private final BookingMapper bookingMapper;
    private final OutboxPublisherService outboxPublisherService;

    public BookingResponse createBooking(Long timeSlotId, AppUser client) {
        TimeSlot slot = timeSlotRepo.findById(timeSlotId)
                .filter(s -> !s.isBooked())
                .orElseThrow(() -> new RuntimeException("Slot is not available"));

        slot.setBooked(true);
        timeSlotRepo.save(slot);

        Booking booking = new Booking();
        booking.setClient(client);
        booking.setTimeSlot(slot);
        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus(BookingStatus.CONFIRMED);

        Booking saved = bookingRepo.save(booking);
        log.info("Booking created: {}", saved.getId());

        return bookingMapper.toResponse(saved);
    }
}
