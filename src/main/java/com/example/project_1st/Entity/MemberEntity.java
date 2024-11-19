package com.example.project_1st.Entity;

import com.example.project_1st.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {

    @Id
    private String memberEmail;

    @Column
    private String memberPassword;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getEmail());
        memberEntity.setMemberPassword(memberDTO.getPassword());

        return memberEntity;
    }
}
