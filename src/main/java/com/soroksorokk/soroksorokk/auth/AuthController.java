package com.soroksorokk.soroksorokk.auth;

import com.soroksorokk.soroksorokk.auth.dto.request.LoginRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.response.LoginResponseDto;
import com.soroksorokk.soroksorokk.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequestDto request) {
        authService.signup(request);
    }
}
