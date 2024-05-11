package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.converter.RestaurantConverter;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_category_id")
    private RestaurantCategory restaurantCategory;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();

    public void setRestaurantCategory(RestaurantCategory restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
        restaurantCategory.getRestaurants().add(this);
    }

    public void setMission(Mission mission) {
        this.missions.add(mission);
    }
}
