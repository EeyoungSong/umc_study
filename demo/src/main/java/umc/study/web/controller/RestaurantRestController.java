package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.RestaurantConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.validation.annotation.ExistRestaurantCategory;
import umc.study.web.dto.RestaurantRequest;
import umc.study.web.dto.RestaurantResponse;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/")
    public ApiResponse<RestaurantResponse.AddRestaurantResultDTO> addRestaurant(
            @RequestParam(value = "restaurantCategoryId", required = true) @ExistRestaurantCategory Long restaurantCategoryId,
            @RequestBody @Valid RestaurantRequest.AddRestaurantDTO request){


        Restaurant restaurant = restaurantCommandService.addRestaurant(restaurantCategoryId, request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }
}
