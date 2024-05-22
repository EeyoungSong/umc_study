package umc.study.service.ChallengingMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.ChallengingMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.service.MemberService.MemberQueryService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChallengingMissionQueryServiceImpl implements ChallengingMissionQueryService {
    private final ChallengingMissionRepository challengingMissionRepository;

    @Override
    public boolean existByMemberAndMissionID(Long memberID, Long missionID) {
        return challengingMissionRepository.existsByMemberIdAndMissionId(memberID, missionID);
    }
}
