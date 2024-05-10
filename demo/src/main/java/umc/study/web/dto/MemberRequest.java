package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class MemberRequest {
    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birthDay;
        @NotNull
        int zipcode;
        @Size(min = 5, max = 50)
        String address;
        @ExistCategories
        List<Long> memberFoodCategory;


    }
}
