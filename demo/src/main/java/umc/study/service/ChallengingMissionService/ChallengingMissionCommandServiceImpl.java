package umc.study.service.ChallengingMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.ChallengingMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.ChallengingMission;
import umc.study.repository.ChallengingMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionRequest;

@Service
@RequiredArgsConstructor
public class ChallengingMissionCommandServiceImpl implements ChallengingMissionCommandService{
    public final MissionRepository missionRepository;
    public final MemberRepository memberRepository;
    public final ChallengingMissionRepository challengeMissionRepository;
    @Override
    @Transactional
    public ChallengingMission addChallengingMission(MissionRequest.AddChallengingMissionDTO request) {
        Member member = memberRepository.findById(request.getMemberID()).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionID()).orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));
        ChallengingMission newChallengingMission = ChallengingMissionConverter.toChallengingMission(member, mission);
        newChallengingMission.setMember(member);
        newChallengingMission.setMission(mission);

        return challengeMissionRepository.save(newChallengingMission);
    }
}
