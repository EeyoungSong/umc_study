package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewResultDTO {
        Long reviewId;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RestaurantReviewPreviewDTO {
        String nickname;
        Double star;
        String body;
        LocalDate createAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberReviewPreviewDTO {
        String nickname;
        Double star;
        String body;
        LocalDate createAt;
        Long restaurantId;
        String restaurantName;
    }



    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewListDTO<T> {
        List<T> reviews;
        Integer listSize;
        Integer totalPage;
        Long totalElemnts;
        Boolean isFirst;
        Boolean isLast;
    }
}
