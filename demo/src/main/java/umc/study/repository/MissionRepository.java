package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
}
