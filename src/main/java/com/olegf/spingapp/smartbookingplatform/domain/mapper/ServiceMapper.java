package com.olegf.spingapp.smartbookingplatform.domain.mapper;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Service;
import com.olegf.spingapp.smartbookingplatform.web.dto.service.ServiceCreateRequest;
import com.olegf.spingapp.smartbookingplatform.web.dto.service.ServiceResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    // DTO → Entity
    Service toEntity(ServiceCreateRequest dto);

    // Entity → DTO
    ServiceResponse toResponse(Service entity);

    // List<Entity> → List<DTO>
    List<ServiceResponse> toResponseList(List<Service> entities);
}
