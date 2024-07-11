package umc.study.service.ChallengingMissionService;

import umc.study.domain.mapping.ChallengingMission;
import umc.study.web.dto.MissionRequest;

public interface ChallengingMissionCommandService {
    ChallengingMission addChallengingMission(MissionRequest.AddChallengingMissionDTO request);

}
