package umc.study.service.ChallengingMissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;

import java.util.Optional;

public interface ChallengingMissionQueryService {
    boolean existByMemberAndMissionID(Long memberID, Long missionID);
}
