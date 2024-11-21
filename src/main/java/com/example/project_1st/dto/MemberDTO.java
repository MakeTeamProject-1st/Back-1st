package com.example.project_1st.dto;

import com.example.project_1st.Entity.MemberEntity;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long memberId;
    private String memberEmail;
    private String memberPassword;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        /*MemberEntity 의 field 를 MemberDTO로 변환해서 설정.
        Entity 의 memberID 는  Integer 이니 Long 을로 변경*/
        memberDTO.setMemberId(Long.valueOf(memberEntity.getMemberId()));
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        return memberDTO;
    }
}
