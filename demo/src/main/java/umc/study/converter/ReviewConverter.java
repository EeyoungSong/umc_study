package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

public class ReviewConverter {
    public static ReviewResponse.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponse.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static Review toReview(ReviewRequest.AddReviewDTO request) {
        return Review.builder()
                .star(request.getStar())
                .body(request.getBody())
                .build();
    }
}
