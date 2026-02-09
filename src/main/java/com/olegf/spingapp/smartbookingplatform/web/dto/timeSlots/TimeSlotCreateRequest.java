package com.olegf.spingapp.smartbookingplatform.web.dto.timeSlots;

import lombok.Data;

@Data
public class TimeSlotCreateRequest {
    private String startTime;
    private String endTime;
    private Long serviceId;
    private Long userId;
}