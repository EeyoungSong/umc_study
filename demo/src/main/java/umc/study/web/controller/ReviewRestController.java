package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;
import umc.study.service.ReviewService.ReviewCommandService;

import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.MemberResponse;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewRepository reviewRepository;

    @PostMapping("/")
    public ApiResponse<ReviewResponse.AddReviewResultDTO> addReview(
            @RequestParam(value = "memberId", required = true) @ExistMember Long memberId,
            @RequestParam(value = "restaurantId", required = true) @ExistRestaurant Long restaurantId,
            @RequestBody @Valid ReviewRequest.AddReviewDTO request){

        Review review = reviewCommandService.addReview(memberId, restaurantId, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
