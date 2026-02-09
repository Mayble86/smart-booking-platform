package com.olegf.spingapp.smartbookingplatform.web.dto.booking;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BookingResponse {
    private Long id;
    private Long clientId;
    private Long timeSlotId;
    private LocalDateTime bookingDate;
    private String status;
}
