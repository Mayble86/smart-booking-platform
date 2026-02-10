package com.olegf.spingapp.smartbookingplatform.domain.service;

import com.olegf.spingapp.smartbookingplatform.domain.mapper.TimeSlotMapper;
import com.olegf.spingapp.smartbookingplatform.domain.repository.TimeSlotRepo;
import com.olegf.spingapp.smartbookingplatform.web.dto.timeSlots.TimeSlotResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TimeSlotService {
    private final TimeSlotRepo timeSlotRepo;
    private final TimeSlotMapper timeSlotMapper;

    public List<TimeSlotResponse> findAvailable(
            LocalDateTime from, LocalDateTime to, Long serviceId) {
        return timeSlotRepo
                .findByIsBookedFalseAndStartTimeAfter(from)
                .stream()
                .filter(slot -> serviceId == null ||
                        slot.getServices()
                                .getId()
                                .equals(serviceId))
                .map(timeSlotMapper::toResponse)
                .toList();
    }
}
