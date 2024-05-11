package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequest {
    @Getter
    public static class AddMissionDTO {

        @NotNull
        int point;

        int price;

        LocalDate deadline;

    }


}
