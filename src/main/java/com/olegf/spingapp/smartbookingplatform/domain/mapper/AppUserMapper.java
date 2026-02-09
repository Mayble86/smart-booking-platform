package com.olegf.spingapp.smartbookingplatform.domain.mapper;

import com.olegf.spingapp.smartbookingplatform.domain.entity.AppUser;
import com.olegf.spingapp.smartbookingplatform.web.dto.user.AppUserResponse;
import com.olegf.spingapp.smartbookingplatform.web.dto.user.RegisterRequest;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", expression = "java(user.getRoles().stream.map(r -> r.getName()).collect(Collectors.toSet()))")
    AppUserResponse toResponse(AppUser user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", ignore = true)
    AppUser toEntity(RegisterRequest dto);

    List<AppUserResponse> toResponseList(List<AppUser> users);
}
