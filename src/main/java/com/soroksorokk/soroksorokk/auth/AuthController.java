package com.soroksorokk.soroksorokk.auth;

import com.soroksorokk.soroksorokk.auth.dto.request.LoginRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.response.LoginResponseDto;
import com.soroksorokk.soroksorokk.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(SignupRequestDto request) {
        authService.signup(request);
    }
}
