package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequest;
import umc.study.web.dto.MemberResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponse.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponse.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequest.JoinDTO request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
        }
        return Member.builder()
                .zipcode(request.getZipcode())
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .birthday(request.getBirthDay())
                .memberFoodCategoryList(new ArrayList<>())
                .build();

    }

}
