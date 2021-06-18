package com.dmolina.authorizeservice.models.dto.jwt;

import com.dmolina.authorizeservice.models.dto.users.GetUserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDto {

    private String token;

    @Builder(builderMethodName="jwtUserResponseBuilder")
    public JwtUserResponse(String username, String avatar, String fullName, String email, List<String> roles, String token) {
        super(username, avatar, fullName, email, roles);
        this.token = token;
    }



}