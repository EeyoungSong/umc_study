package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;

import java.util.Optional;

public interface MemberQueryService {
    public boolean existById(Long id);

    Optional<Member> findMember(Long id);
    Page<Review> getReviewList(Long memberId, Integer page);
}
