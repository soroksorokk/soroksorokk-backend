package com.soroksorokk.soroksorokk.user.service;

import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateUserInfoService {
    private final UserRepository userRepository;

    public ValidateUserInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByNickname(String nickname) {
        return userRepository.existsByEmail(nickname);
    }
}
