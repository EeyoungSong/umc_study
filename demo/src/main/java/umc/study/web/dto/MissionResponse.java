package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResultDTO {
        Long missionId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RestaurantMissionPreviewDTO {
        String restaurantName;
        Integer point;
        Integer price;
        LocalDate deadLine;
        LocalDate createAt;
    }




    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewListDTO<T> {
        List<T> missions;
        Integer listSize;
        Integer totalPage;
        Long totalElemnts;
        Boolean isFirst;
        Boolean isLast;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddChallengingMissionResultDTO {
        Long memberMissionID;
        LocalDateTime createdAt;
    }
}
