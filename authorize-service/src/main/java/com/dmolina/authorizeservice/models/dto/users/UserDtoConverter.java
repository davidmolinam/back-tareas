package com.dmolina.authorizeservice.models.dto.users;

import com.dmolina.authorizeservice.models.vo.users.UserEntity;
import com.dmolina.authorizeservice.models.vo.users.UserRole;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
        return GetUserDto.builder()
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(UserRole::name)
                        .collect(Collectors.toList())
                ).build();
    }

}