package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.ChallengingMission;

public interface ChallengingMissionRepository extends JpaRepository<ChallengingMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
