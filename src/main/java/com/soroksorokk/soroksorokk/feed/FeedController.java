package com.soroksorokk.soroksorokk.feed;

import com.soroksorokk.soroksorokk.feed.dto.request.CreateFeedRequestDto;
import com.soroksorokk.soroksorokk.feed.dto.request.GetFeedResponseDto;
import com.soroksorokk.soroksorokk.feed.dto.request.UpdateFeedRequestDto;
import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feeds")
public class FeedController {
    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(CreateFeedRequestDto request, @AuthenticationPrincipal UserDetails user) {
        feedService.createFeed(request, user.getUsername());
    }

    @GetMapping
    public ResponseEntity<List<GetAllFeedsResponseDto>> getAllFeeds() {
        return ResponseEntity.ok(feedService.getAllFeeds());
    }

    @PutMapping("/{id}")
    public void updateFeed(@PathVariable("id") Long id, @RequestBody UpdateFeedRequestDto request,
                           @AuthenticationPrincipal UserDetails userDetails) {
        feedService.updateFeed(id, request, userDetails.getUsername());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetFeedResponseDto> getFeed(@PathVariable("id") Long id) {
         return ResponseEntity.ok(feedService.getFeed(id));
    }

    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable("id") Long id) {
        feedService.deleteFeedById(id);
    }
}
