package com.olegf.spingapp.smartbookingplatform.domain.mapper;

import com.olegf.spingapp.smartbookingplatform.domain.entity.TimeSlot;
import com.olegf.spingapp.smartbookingplatform.web.dto.timeSlots.TimeSlotCreateRequest;
import com.olegf.spingapp.smartbookingplatform.web.dto.timeSlots.TimeSlotResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlot toEntity(TimeSlotCreateRequest dto);

    TimeSlotResponse toResponse(TimeSlotCreateRequest entity);

    List<TimeSlot> toResponse(List<TimeSlot> entities);
}
