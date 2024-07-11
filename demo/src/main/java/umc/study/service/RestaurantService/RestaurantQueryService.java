package umc.study.service.RestaurantService;


import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;

import java.util.Optional;

public interface RestaurantQueryService {
    public boolean existById(Long id);

    Optional<Restaurant> findRestaurant(Long id);

    Page<Review> getReviewList(Long restaurantId, Integer page);

    Page<Mission> getMissions(Long restaurantId, Integer page);
}
