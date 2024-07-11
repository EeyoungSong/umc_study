package umc.study.service.RestaurantService;

import umc.study.domain.Member;
import umc.study.domain.Restaurant;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.RestaurantRequest;

public interface RestaurantCommandService {
    Restaurant addRestaurant(Long restaurantCategoryId, RestaurantRequest.AddRestaurantDTO request);

}
