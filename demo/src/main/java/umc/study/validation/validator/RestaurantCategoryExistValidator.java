package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.RestaurantCategory;
import umc.study.repository.RestaurantCategoryRepository;
import umc.study.repository.RestaurantRepository;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.validation.annotation.ExistRestaurantCategory;

@Component
@RequiredArgsConstructor
public class RestaurantCategoryExistValidator implements ConstraintValidator<ExistRestaurantCategory, Long> {

    private final RestaurantCategoryRepository restaurantCategoryRepository;

    @Override
    public void initialize(ExistRestaurantCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantCategoryRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTURANT_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
