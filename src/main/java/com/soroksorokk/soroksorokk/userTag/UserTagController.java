package com.soroksorokk.soroksorokk.userTag;

import com.soroksorokk.soroksorokk.userTag.dto.request.CreateUserTagRequestDto;
import com.soroksorokk.soroksorokk.userTag.dto.request.ModifyUserTagRequestDto;
import com.soroksorokk.soroksorokk.userTag.service.UserTagService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user-tags")
@RestController
public class UserTagController {

    private final UserTagService userTagService;

    public UserTagController(UserTagService userTagService) {
        this.userTagService = userTagService;
    }

    @PostMapping
    public void createUserTag(
            CreateUserTagRequestDto request,
            @AuthenticationPrincipal UserDetails userDetails) {
        userTagService.createUserTag(userDetails.getUsername(), request);
    }

    @PutMapping("/{id}")
    public void modifyUserTag(
            @PathVariable("id") Long id,
            ModifyUserTagRequestDto request,
            @AuthenticationPrincipal UserDetails userDetails) {
        userTagService.modifyUserTag(userDetails.getUsername(), id, request);
    }

    @GetMapping
    public void getAllUserTags(@AuthenticationPrincipal UserDetails userDetails) {
        userTagService.getAllUserTags(userDetails.getUsername());
    }

    @DeleteMapping("/{id}")
    public void deleteUserTag(
            @PathVariable("id") Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        userTagService.deleteUserTag(userDetails.getUsername(), id);
    }
}
