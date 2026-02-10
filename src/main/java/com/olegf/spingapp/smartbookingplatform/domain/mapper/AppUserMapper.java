package com.olegf.spingapp.smartbookingplatform.domain.mapper;

import com.olegf.spingapp.smartbookingplatform.domain.entity.AppUser;
import com.olegf.spingapp.smartbookingplatform.domain.entity.Role;
import com.olegf.spingapp.smartbookingplatform.web.dto.user.AppUserResponse;
import com.olegf.spingapp.smartbookingplatform.web.dto.user.RegisterRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserResponse toResponse(AppUser user);

    AppUser toEntity(RegisterRequest dto);

    List<AppUserResponse> toResponseList(List<AppUser> users);

    default Set<String> rolesToString(Set<Role> roles) {
        if (roles == null) return new HashSet<>();
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }
}
