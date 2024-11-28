package com.example.project_1st.controller;

import com.example.project_1st.dto.ReplyDTO;
import com.example.project_1st.service.ReplyService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyApiController {

    private final ReplyService replyService;

    // 댓글 저장
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ReplyDTO replyDTO) {
        // 디버깅용 로그 출력
        System.out.println("ReplyApiController.save - 정상행위 확인");
        System.out.println("replyDTO = " + replyDTO);

        replyService.save(replyDTO); // 댓글 저장
        return ResponseEntity.ok("post"); // 성공 시 "post" 반환
    }

    // 댓글 등록 후 게시글 이동 처리
    @PostMapping("/post")
    public ResponseEntity<String> replyPost(@RequestBody ReplyDTO replyDTO, HttpSession session) {
        ReplyDTO replyPostResult = replyService.save(replyDTO);
        if (replyPostResult != null) {
            session.setAttribute("postReply", replyPostResult);
            return ResponseEntity.ok("reply_saved");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("reply_failed");
        }
    }
}
