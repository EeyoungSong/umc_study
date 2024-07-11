package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistMission;

import java.time.LocalDate;

public class MissionRequest {
    @Getter
    public static class AddMissionDTO {

        @NotNull
        int point;
        int price;
        LocalDate deadline;

    }

    @Getter
    public static class AddChallengingMissionDTO {

        @NotNull
        @ExistMember
        Long memberID;

        @NotNull
        @ExistMission
        Long missionID;
    }
}
