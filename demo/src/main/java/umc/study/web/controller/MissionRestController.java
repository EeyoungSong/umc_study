package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.MissionRequest;
import umc.study.web.dto.MissionResponse;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionRepository missionRepository;

    @PostMapping("/")
    public ApiResponse<MissionResponse.AddMissionResultDTO> addReview(
            @RequestParam(value = "restaurantId", required = true) @ExistRestaurant Long restaurantId,
            @RequestBody @Valid MissionRequest.AddMissionDTO request){

        Mission mission = missionCommandService.addMission(restaurantId, request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }
}
