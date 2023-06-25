package com.soroksorokk.soroksorokk.feed;

import com.soroksorokk.soroksorokk.feed.dto.request.CreateFeedRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feeds")
public class FeedController {

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    private final FeedService feedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(CreateFeedRequestDto request, @AuthenticationPrincipal UserDetails user) {
        feedService.createFeed(request, user.getUsername());
    }
}
