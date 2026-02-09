package com.olegf.spingapp.smartbookingplatform.web.dto.timeSlots;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TimeSlotResponse {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long serviceId;
    private Long userId;
    private boolean isBooked;
}
