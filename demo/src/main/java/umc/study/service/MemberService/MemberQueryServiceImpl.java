package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean existById(Long id) {
        return memberRepository.existsById(id);
    }

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = findMember(memberId).get();

        return reviewRepository.findAllByMember(member, PageRequest.of(page-1, 10));
    }
}
