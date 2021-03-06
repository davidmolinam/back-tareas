package com.dmolina.authorizeservice.models.dto.users;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class GetUserDto {

    private String username;
    private String avatar;
    private String fullName;
    private String email;
    private List<String> roles;



}