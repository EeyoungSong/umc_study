package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;

import umc.study.domain.Review;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.MemberResponse;
import umc.study.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;


    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> join(@RequestBody @Valid MemberRequest.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberID}/review")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query string으로 page 번호를 주세요.")
    @Parameters({
            @Parameter(name = "memberId", description = "유저 ID, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호 1페이지부터 시작 입니다."),
    })
    public ApiResponse<ReviewResponse.ReviewPreviewListDTO<ReviewResponse.RestaurantReviewPreviewDTO>> getReviewList(
            @ExistRestaurant @PathVariable(name = "memberID") Long restaurantId,
            @RequestParam(name = "page") Integer page
    ){
        Page<Review> reviewPage = memberQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.toRestaurantReviewPreviewListDTO(reviewPage));
    }
}
