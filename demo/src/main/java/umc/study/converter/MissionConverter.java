package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MissionConverter {

    public static MissionResponse.AddMissionResultDTO toAddMissionResultDTO(Mission mission) {
        return MissionResponse.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequest.AddMissionDTO request) {

        Gender gender = null;

        return Mission.builder()
                .point(request.getPoint())
                .price(request.getPrice())
                .deadline(request.getDeadline())
                .build();

    }

    public static MissionResponse.MissionPreviewListDTO<MissionResponse.RestaurantMissionPreviewDTO> toRestaurantMissionPreviewListDTO(Page<Mission> missions) {
        List<MissionResponse.RestaurantMissionPreviewDTO> restaurantMissionPreviewDTOS = missions.stream()
                .map(MissionConverter::toRestaurantMissionPreviewDTO).toList();

        return MissionResponse.MissionPreviewListDTO.<MissionResponse.RestaurantMissionPreviewDTO>builder()
                .isLast(missions.isLast())
                .isFirst(missions.isFirst())
                .totalPage(missions.getTotalPages())
                .totalElemnts(missions.getTotalElements())
                .listSize(restaurantMissionPreviewDTOS.size())
                .missions(restaurantMissionPreviewDTOS)
                .build();
    }

    public static MissionResponse.RestaurantMissionPreviewDTO toRestaurantMissionPreviewDTO(Mission mission){
        return MissionResponse.RestaurantMissionPreviewDTO.builder()
                .restaurantName(mission.getRestaurant().getName())
                .point(mission.getPoint())
                .price(mission.getPrice())
                .deadLine(mission.getDeadline())
                .build();
    }

}
