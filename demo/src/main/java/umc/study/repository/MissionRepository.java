package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;

public interface MissionRepository extends JpaRepository<Member, Long> {
}
