package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.repository.MissionRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.web.dto.MissionRequest;

@Service
@RequiredArgsConstructor
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Mission addMission(Long restaurantId, MissionRequest.AddMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new TempHandler(ErrorStatus.RESTURANT_NOT_FOUND));;
        restaurant.setMission(newMission);

        return missionRepository.save(newMission);
    }
}
