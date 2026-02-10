package com.olegf.spingapp.smartbookingplatform.domain.mapper;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Booking;
import com.olegf.spingapp.smartbookingplatform.web.dto.booking.BookingCreateRequest;
import com.olegf.spingapp.smartbookingplatform.web.dto.booking.BookingResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toEntity(BookingCreateRequest dto);

    BookingResponse toResponse(Booking entity);

    List<BookingResponse> toResponseList(List<Booking> entities);
}
