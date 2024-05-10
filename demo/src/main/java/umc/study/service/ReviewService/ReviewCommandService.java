package umc.study.service.ReviewService;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.ReviewRequest;

public interface ReviewCommandService {
    Review addReview(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request);

    void check(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request);

    void check2();
}

