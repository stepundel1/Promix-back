package com.nawerno.promyshia.controller;

import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.payload.request.LoginRequest;
import com.nawerno.promyshia.payload.response.JwtResponse;
import com.nawerno.promyshia.payload.response.MessageResponse;
import com.nawerno.promyshia.security.jwt.JwtUtils;
import com.nawerno.promyshia.security.service.UserDetailsImpl;
import com.nawerno.promyshia.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Auth")
@Tag(name = "контроллер авторизации")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    public AuthController(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signup")
    @Operation(summary = "регистрация")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if (userService.existsByEmail(user.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("error: Email already taken"));
        }
        userService.create(user, encoder.encode(user.getPassword()));


        return ResponseEntity.ok(new MessageResponse("получилось"));
    }

    @PostMapping("/signin")
    @Operation(summary = "Вход в систему")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }
}

