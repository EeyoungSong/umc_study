package umc.study.converter;


import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

import java.util.List;

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

    public static ReviewResponse.ReviewPreviewListDTO<ReviewResponse.RestaurantReviewPreviewDTO> toRestaurantReviewPreviewListDTO(Page<Review> reviews) {
        List<ReviewResponse.RestaurantReviewPreviewDTO> restaurantReviewPreviewDTOS = reviews.stream()
                .map(ReviewConverter::toRestaurantReviewPreviewDTO).toList();

        return ReviewResponse.ReviewPreviewListDTO.<ReviewResponse.RestaurantReviewPreviewDTO>builder()
                .isLast(reviews.isLast())
                .isFirst(reviews.isFirst())
                .totalPage(reviews.getTotalPages())
                .totalElemnts(reviews.getTotalElements())
                .listSize(restaurantReviewPreviewDTOS.size())
                .reviews(restaurantReviewPreviewDTOS)
                .build();
    }

    public static ReviewResponse.RestaurantReviewPreviewDTO toRestaurantReviewPreviewDTO(Review review){
        return ReviewResponse.RestaurantReviewPreviewDTO.builder()
                .nickname(review.getMember().getName())
                .star(review.getStar())
                .createAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
}
