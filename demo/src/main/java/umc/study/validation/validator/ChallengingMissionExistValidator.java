package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.mapping.ChallengingMission;
import umc.study.service.ChallengingMissionService.ChallengingMissionQueryService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotation.ExistChallengingMission;
import umc.study.validation.annotation.ExistMission;
import umc.study.web.dto.MissionRequest;

@Component
@RequiredArgsConstructor
public class ChallengingMissionExistValidator implements ConstraintValidator<ExistChallengingMission, MissionRequest.AddChallengingMissionDTO> {

    private final ChallengingMissionQueryService challengingMissionQueryService;

    @Override
    public void initialize(ExistChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequest.AddChallengingMissionDTO value, ConstraintValidatorContext context) {
        boolean isValid = challengingMissionQueryService.existByMemberAndMissionID(value.getMemberID(), value.getMissionID());

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.EXITS_CHALLENGING_MISSION.toString()).addConstraintViolation();
        }
        return (!isValid);
    }
}
