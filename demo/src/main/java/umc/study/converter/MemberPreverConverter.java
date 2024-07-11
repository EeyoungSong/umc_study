package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreverConverter {

    public static List<MemberPrefer> toMemberPrefers(List<FoodCategory> foodCategories) {

        return foodCategories.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory) // food category 객체 추가 MemeberPrefer에 추가 (연결)
                                .build()
                ).collect(Collectors.toList());
    }
}
