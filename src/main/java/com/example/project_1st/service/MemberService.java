package com.example.project_1st.service;

import com.example.project_1st.Entity.MemberEntity;
import com.example.project_1st.dto.MemberDTO;
import com.example.project_1st.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

// 회원 비즈니스 로직 처리하는 서비스 클래스 만들기.
@Service    // Spring Bean 으로 등록해서, 의존성주입 가능.
@RequiredArgsConstructor    // final field 에 대해 생성자 자동생성 ( LOMBOK )
public class MemberService {

    private final MemberRepository memberRepository;    // 회원정보 관리위한 JPA 레포 의존성 주입하기.

    // 회원가입 로직 만들기
    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO); // DTO를 Entity 객체로 변환
        memberRepository.save(memberEntity);    // 레포지토리의 save 를 호출하여 DB에 저장한다. ( Repo 의 save 는 Entity 만 받을수있음)
    }

    // 로그인 로직 구현
    public MemberDTO login(MemberDTO memberDTO) {

        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail()); // Email 로 회원정보 조회하기 (Optional 로 감싸진 결과 반환)

        if (byMemberEmail.isPresent()) {      // if - 조회결과 존재한다면
            MemberEntity memberEntity = byMemberEmail.get();    // Optional 에서 실 객체를 꺼낸다.

            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {     // 비밀번호 비교하기. if -  Entity 와 DTO 비밀번호가 같다면
                return MemberDTO.toMemberDTO(memberEntity); // 로그인 성공. MemberDTO 를 memberEntity로 변환해주자.
            } else {
                return null;    // 비밀번호 틀리면? 로그인 실패.
            }
        } else {
            return null;    // 이메일(ID) 없으면 ? 로그인 실패
        }
    }
}