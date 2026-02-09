package com.olegf.spingapp.smartbookingplatform.domain.mapper;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Notification;
import com.olegf.spingapp.smartbookingplatform.web.dto.notification.NotificationResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationResponse toResponse(Notification entity);

    List<NotificationResponse> toResponseList(List<Notification> entities);
}
