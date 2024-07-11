package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.ChallengingMission;
import umc.study.web.dto.MissionResponse;

public class ChallengingMissionConverter {
    public static MissionResponse.AddChallengingMissionResultDTO toAddChallengingMissionResultDTO(ChallengingMission memberMission) {
        return MissionResponse.AddChallengingMissionResultDTO.builder()
                .memberMissionID(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
    public static ChallengingMission toChallengingMission(Member member, Mission mission) {
        return ChallengingMission.builder()
                .mission(mission)
                .member(member)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
