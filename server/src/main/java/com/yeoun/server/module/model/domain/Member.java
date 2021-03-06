package com.yeoun.server.module.model.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;
    private String name;
    private String nickname;
    private String profileImage;
    private String phone;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Liked> likedList = new ArrayList<>();

    @Builder
    public Member(Long memberId,
                  String email,
                  String password,
                  String name,
                  String nickname,
                  String profileImage,
                  String phone,
                  MemberType memberType) {
        this.id = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.phone = phone;
        this.memberType = memberType;
    }
}
