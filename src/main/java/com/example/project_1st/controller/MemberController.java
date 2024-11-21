package com.example.project_1st.controller;

import com.example.project_1st.dto.MemberDTO;
import com.example.project_1st.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor       // final field 의 생성자를 자동으로 생성해줌.(Lombok 기능)
public class MemberController {

    private final MemberService memberService;  // 생성자 주입하기.(서비스계층 의존성 주입)

    //  회원가입 페이지 요청 처리하기.
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";  // 회원가입 페이지 출력하기.
    }

    //  회원가입 요청 처리하기.
    @PostMapping("/member/save")
    public ResponseEntity<String> save(@RequestBody MemberDTO memberDTO) {
        // 정상적인 행위가 되는지 확인. (디버그용)
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return ResponseEntity.ok("login");     // 회원가입 성공 후 로그인 페이지로 이동.
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login"; // 로그인 페이지로 이동
    }

    //  로그인 요청 처리하기.
    @PostMapping("/member/login")
    public ResponseEntity<String> login(@RequestBody MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);     // 서비스 계층에서 로그인 처리 반환하기.

        if (loginResult != null) {      // if - login 성공시
            session.setAttribute("loginEmail", loginResult.getMemberEmail());   // 세션에 이메일 저장하기.
            System.out.println("login successful : " + loginResult.getMemberEmail());    // 디버그용 로그 출력하기
            return ResponseEntity.ok("main");  // login 성공 시 메인 페이지로 이동하기
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패"); // else - login 실패시 로그인페이지로 다시 이동하기.
        }
    }
}
