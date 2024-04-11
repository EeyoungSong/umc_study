package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.Member_allowance;
import umc.study.domain.mapping.Member_food_category;
import umc.study.domain.mapping.Member_mission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 내가 사용하는 db에게 맡김
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    private LocalDate birthday;

    private int zipcode;

    @Column(nullable = false, length = 50)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private MemberStatus memberStatus;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 30)
    private String email;

    private Integer point;

    private boolean location_allowance;

    private boolean marketing_allowance;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Member_allowance> memberAllowanceList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private  List<Member_food_category> memberFoodCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Member_mission> memberMissionList = new ArrayList<>();
}
