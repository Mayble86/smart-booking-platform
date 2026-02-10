package com.olegf.spingapp.smartbookingplatform.domain.mapper;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Serve;
import com.olegf.spingapp.smartbookingplatform.web.dto.serve.ServeCreateRequest;
import com.olegf.spingapp.smartbookingplatform.web.dto.serve.ServeResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServeMapper {
    // DTO → Entity
    Serve toEntity(ServeCreateRequest dto);

    // Entity → DTO
    ServeResponse toResponse(Serve entity);

    // List<Entity> → List<DTO>
    List<ServeResponse> toResponseList(List<Serve> entities);
}
