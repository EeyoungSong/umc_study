package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class RestaurantRequest {
    @Getter
    public static class AddRestaurantDTO {
        @NotBlank
        String name;
        @NotNull
        String address;


    }
}
