package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberPreverConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.ReviewRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reveiwRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public Review addReview(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request) {

        Review newReview = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new TempHandler(ErrorStatus.RESTURANT_NOT_FOUND));
        newReview.setMember(member);
        newReview.setRestaurant(restaurant);

        return reveiwRepository.save(newReview);
    }

    @Override
    public void check(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request) {
        memberRepository.findById(memberId).orElseThrow(
                () -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND)
        ).getReviews().forEach(
                r -> System.out.println("reviewId : " + r.getId() + ", restaurantId : " + r.getRestaurant().getId()));
        restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new TempHandler(ErrorStatus.RESTURANT_NOT_FOUND)
        ).getReviews().forEach(
                r -> System.out.println("reviewId : " + r.getId() + ", restaurantId : " + r.getMember().getId()));
    }

    @Override
    public void check2() {
        memberRepository.findById(1L).orElseThrow(
                        () -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", restaurantId : " + r.getRestaurant().getId()));
        restaurantRepository.findById(1L).orElseThrow(
                        () -> new TempHandler(ErrorStatus.RESTURANT_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", memberId : "  + r.getMember().getId()));
    }
}
