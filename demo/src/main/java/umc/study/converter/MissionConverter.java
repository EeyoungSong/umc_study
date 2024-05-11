package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.MemberResponse;
import umc.study.web.dto.MissionRequest;
import umc.study.web.dto.MissionResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

}
