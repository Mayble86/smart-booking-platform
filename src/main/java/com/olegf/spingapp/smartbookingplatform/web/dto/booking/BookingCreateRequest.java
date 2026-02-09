package com.olegf.spingapp.smartbookingplatform.web.dto.booking;

import lombok.Data;

@Data
public class BookingCreateRequest {
    private Long clientId;
    private Long timeSlotId;
}
