package com.example.project_1st.controller;

import com.example.project_1st.dto.MemberDTO;
import com.example.project_1st.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor       // final field 의 생성자를 자동으로 생성해줌.(Lombok 기능)
public class MemberController {

    private final MemberService memberService;  // 생성자 주입하기.(서비스계층 의존성 주입)

    //  회원가입 페이지 요청 처리하기.
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";  // 회원가입 페이지 출력하기.
    }

    //  회원가입 요청 처리하기.
    public String save(ModelAttribute MemberDTO memberDTO) {
        // 정상적인 행위가 되는지 확인. (디버그용)
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "login";     // 회원가입 성공 후 로그인 페이지로 이동.
    }

    //  로그인 요청 처리하기.
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);     // 서비스 계층에서 로그인 처리 반환하기.

        if (loginResult != null) {      // if - login 성공시
            session.setAttribute("loginEmail", loginResult.getMemberEmail());   // 세션에 이메일 저장하기.
            System.out.println("login successful : " + loginResult.getEmail());    // 디버그용 로그 출력하기
            return "main";  // login 성공 시 메인 페이지로 이동하기
        } else {
            return "login"; // else - login 실패시 로그인페이지로 다시 이동하기.
        }
    }
}
