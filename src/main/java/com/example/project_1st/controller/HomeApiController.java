package com.example.project_1st.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeApiController {

    @GetMapping("/")    // 홈페이지 요청
    public String index(){
        return "index";     // -> templates 폴더의 index.html을 찾음.
    }

}
