package com.example.project_1st.service;

import com.example.project_1st.dto.MemberDTO;
import com.example.project_1st.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// TODO 회원 비즈니스 로직 처리하는 서비스 클래스 만들기.
@Service    // Spring Bean 으로 등록해서, 의존성주입 가능.
@RequiredArgsConstructor    // final field 에 대해 생성자 자동생성 ( LOMBOK )
public class MemberService {

    private final MemberRepository memberRepository;    // 회원정보 관리위한 JPA 레포 의존성 주입하기.

    // TODO 회원가입 로직
    public void save(MemberDTO memberDTO){

    }
}
