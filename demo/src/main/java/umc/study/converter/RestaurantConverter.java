package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.web.dto.RestaurantRequest;
import umc.study.web.dto.RestaurantResponse;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

public class RestaurantConverter {
    public static RestaurantResponse.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant) {
        return RestaurantResponse.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }
    public static Restaurant toRestaurant(RestaurantRequest.AddRestaurantDTO request) {
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
