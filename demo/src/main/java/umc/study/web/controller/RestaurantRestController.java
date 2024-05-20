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
import umc.study.converter.MissionConverter;
import umc.study.converter.RestaurantConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.service.RestaurantService.RestaurantQueryService;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.validation.annotation.ExistRestaurantCategory;
import umc.study.web.dto.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponse.AddRestaurantResultDTO> addRestaurant(
            @RequestParam(value = "restaurantCategoryId", required = true) @ExistRestaurantCategory Long restaurantCategoryId,
            @RequestBody @Valid RestaurantRequest.AddRestaurantDTO request){


        Restaurant restaurant = restaurantCommandService.addRestaurant(restaurantCategoryId, request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }

    @GetMapping("/{restaurantID}/review")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query string으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호 1페이지부터 시작 입니다."),
    })
    public ApiResponse<ReviewResponse.ReviewPreviewListDTO<ReviewResponse.RestaurantReviewPreviewDTO>> getReviewList(
            @ExistRestaurant @PathVariable(name = "restaurantID") Long restaurantId,
            @RequestParam(name = "page") Integer page
    ){
        Page<Review> reviewPage = restaurantQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.toRestaurantReviewPreviewListDTO(reviewPage));
    }

    @GetMapping("/{restaurantID}/mission")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query string으로 page 번호를 주세요.")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호 1페이지부터 시작 입니다."),
    })
    public ApiResponse<MissionResponse.MissionPreviewListDTO<MissionResponse.RestaurantMissionPreviewDTO>> getMissionList(
            @ExistRestaurant @PathVariable(name = "restaurantID") Long restaurantId,
            @RequestParam(name = "page") Integer page
    ){
        Page<Mission> missionPage = restaurantQueryService.getMissions(restaurantId, page);
        return ApiResponse.onSuccess(MissionConverter.toRestaurantMissionPreviewListDTO(missionPage));
    }
}
