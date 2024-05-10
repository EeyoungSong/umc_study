package umc.study.service.RestaurantService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.TempHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberPreverConverter;
import umc.study.converter.RestaurantConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.*;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.RestaurantCategoryRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.RestaurantRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {
    private final RestaurantCategoryRepository restaurantCategoryRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant(Long restaurantCategoryId, RestaurantRequest.AddRestaurantDTO request){


        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);
        RestaurantCategory restaurantCategory = restaurantCategoryRepository.findById(restaurantCategoryId).orElseThrow(
                () -> new TempHandler(ErrorStatus.RESTURANT_CATEGORY_NOT_FOUND));
        newRestaurant.setRestaurantCategory(restaurantCategory);

        return restaurantRepository.save(newRestaurant);
    }
}
