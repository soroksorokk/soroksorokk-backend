package com.soroksorokk.soroksorokk.user;

import com.soroksorokk.soroksorokk.user.dto.request.EmailRequestDto;
import com.soroksorokk.soroksorokk.user.dto.request.NicknameRequestDto;
import com.soroksorokk.soroksorokk.user.service.ValidateUserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final ValidateUserInfoService validateUserInfoService;

    public UserController(ValidateUserInfoService validateUserInfoService) {
        this.validateUserInfoService = validateUserInfoService;
    }

    @PostMapping("/validate/email")
    public void validateEmail(@RequestBody() EmailRequestDto request) {
        validateUserInfoService.existsByEmail(request.email());
    }

    @PostMapping("/validate/nickname")
    public void validateNickname(@RequestBody() NicknameRequestDto request) {
        validateUserInfoService.existsByNickname(request.nickname());
    }
}
