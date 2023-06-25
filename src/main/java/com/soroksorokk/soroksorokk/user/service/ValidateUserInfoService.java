package com.soroksorokk.soroksorokk.user.service;

import com.soroksorokk.soroksorokk.user.exception.EmailInUseException;
import com.soroksorokk.soroksorokk.user.exception.NicknameInUseException;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateUserInfoService {
    private final UserRepository userRepository;

    public ValidateUserInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByEmail(String email) {
        boolean exists = userRepository.existsByEmail(email);

        if (exists) {
            throw new EmailInUseException();
        }

        return false;
    }

    public boolean existsByNickname(String nickname) {
        boolean exists = userRepository.existsByNickname(nickname);

        if (exists) {
            throw new NicknameInUseException();
        }

        return false;
    }
}
