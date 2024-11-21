package com.example.project_1st.Entity;

import com.example.project_1st.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "users")
public class MemberEntity {

    @Id     // memberId 는 기본키로 쓸거임. 그래서 @Id 들어감.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // IDENTITY 사용하여 i++ 해줌.
    private Integer memberId; // MySQL INTEGER에 맞춰 타입 변경

    @Column(unique = true, nullable = false)    //  유니크 제약조건 추가.
    private String memberEmail;

    @Column(nullable = false)       //  nullable = false ? memberEmail과 마찬가지로 NOT NULL 이 되야함.
    private String memberPassword;

    @CreationTimestamp      // 생성일시 자동설정
    @Column(name = "created_at", updatable = false)     // updatable = false 로 수정불가함.
    private Timestamp createdAt; // DDL에 맞춰서 추가

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        return memberEntity;
    }
}