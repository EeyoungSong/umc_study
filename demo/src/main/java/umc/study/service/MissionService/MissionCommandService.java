package umc.study.service.MissionService;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.MissionRequest;

public interface MissionCommandService {
    Mission addMission(Long restaurantId, MissionRequest.AddMissionDTO request);
}
