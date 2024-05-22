package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ChallengingMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.ChallengingMission;
import umc.study.service.ChallengingMissionService.ChallengingMissionCommandService;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.validation.annotation.ExistChallengingMission;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.MissionRequest;
import umc.study.web.dto.MissionResponse;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final ChallengingMissionCommandService challengingMissionCommandService;


    @PostMapping("/")
    public ApiResponse<MissionResponse.AddMissionResultDTO> addReview(
            @RequestParam(value = "restaurantId", required = true) @ExistRestaurant Long restaurantId,
            @RequestBody @Valid MissionRequest.AddMissionDTO request){

        Mission mission = missionCommandService.addMission(restaurantId, request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

    @PostMapping("/challenging")
    public ApiResponse<MissionResponse.AddChallengingMissionResultDTO> addChallengingMission(
            @RequestBody @ExistChallengingMission @Valid MissionRequest.AddChallengingMissionDTO request){
        ChallengingMission challengingMission = challengingMissionCommandService.addChallengingMission(request);
        return ApiResponse.onSuccess(ChallengingMissionConverter.toAddChallengingMissionResultDTO(challengingMission));
    }
}
