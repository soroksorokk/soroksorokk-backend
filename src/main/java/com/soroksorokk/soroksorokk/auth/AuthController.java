package com.soroksorokk.soroksorokk.auth;

import com.soroksorokk.soroksorokk.auth.dto.request.EmailRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.LoginRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.response.LoginResponseDto;
import com.soroksorokk.soroksorokk.auth.service.AuthService;
import com.soroksorokk.soroksorokk.user.service.ValidateUserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;
    private final ValidateUserInfoService validateUserInfoService;

    public AuthController(AuthService authService, ValidateUserInfoService validateUserInfoService) {
        this.authService = authService;
        this.validateUserInfoService = validateUserInfoService;
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

    @PostMapping("/signup/validate/email")
    public void validateEmail(@RequestBody()EmailRequestDto request) {
        validateUserInfoService.existsByEmail(request.email());
    }
}
