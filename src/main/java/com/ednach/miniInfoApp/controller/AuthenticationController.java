package com.ednach.miniInfoApp.controller;

import com.ednach.dto.request.UserRegistrationRequestDTO;
import com.ednach.dto.request.UserSignInRequestDto;
import com.ednach.dto.response.TokenResponseDto;
import com.ednach.dto.response.UserResponseDto;
import com.ednach.model.Role;
import com.ednach.model.User;
import com.ednach.service.RoleService;
import com.ednach.service.UserService;
import com.ednach.service.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;
    private final RoleService roleService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final Mapper mapper;

    @PostMapping("/signIn")
    public TokenResponseDto authenticateUser(@Valid @RequestBody UserSignInRequestDto userSignInRequestDto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userSignInRequestDto.getUsername(), userSignInRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new TokenResponseDto(tokenService.generate(authentication));
    }

    @PostMapping("/refresh")
    public TokenResponseDto refreshToken(@RequestParam String token) {
        return new TokenResponseDto(tokenService.refresh(token));
    }

    @PostMapping("/signUp")
    public UserResponseDto registerUser(@Valid @RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO) {
        final User user = new User();
        user.setName(userRegistrationRequestDTO.getName());
        user.setPassword(userRegistrationRequestDTO.getPassword());
        user.setEmail(userRegistrationRequestDTO.getEmail());
        final Set<Role> roles = userRegistrationRequestDTO.getRoles().stream()
                .map(roleService::findByRoleNome)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return mapper.map(userService.save(user), UserResponseDto.class);
    }
}
