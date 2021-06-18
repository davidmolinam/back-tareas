package com.dmolina.authorizeservice.controllers;

import com.dmolina.authorizeservice.models.dto.jwt.JwtUserResponse;
import com.dmolina.authorizeservice.models.dto.jwt.LoginRequest;
import com.dmolina.authorizeservice.models.dto.users.GetUserDto;
import com.dmolina.authorizeservice.models.dto.users.UserDtoConverter;
import com.dmolina.authorizeservice.models.vo.users.UserEntity;
import com.dmolina.authorizeservice.models.vo.users.UserRole;
import com.dmolina.authorizeservice.services.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserDtoConverter converter;

    @PostMapping("/auth/login")
    public JwtUserResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()

                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserEntity user = (UserEntity) authentication.getPrincipal();
        String jwtToken = tokenProvider.generateToken(authentication);

        return convertUserEntityAndTokenToJwtUserResponse(user, jwtToken);

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/me")
    public GetUserDto me(@AuthenticationPrincipal UserEntity user) {
        return converter.convertUserEntityToGetUserDto(user);
    }



    private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(UserEntity user, String jwtToken) {
        return JwtUserResponse
                .jwtUserResponseBuilder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toList()))
                .token(jwtToken)
                .build();

    }

}