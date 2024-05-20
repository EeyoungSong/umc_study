package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.MissionRepository;
import umc.study.repository.RestaurantQueryRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final RestaurantQueryRepository restaurantQueryRepository;
    private final MissionRepository missionRepository;


    public boolean existById(Long id) {
      return restaurantRepository.existsById(id);
    };

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = findRestaurant(restaurantId).get();

        return reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page-1, 10));
    }

    @Override
    public Page<Mission> getMissions(Long restaurantId, Integer page) {
        Restaurant restaurant = findRestaurant(restaurantId).get();
        return missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page-1, 10));
    }
}
