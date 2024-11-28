package com.example.project_1st.controller;

import com.example.project_1st.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeApiController {

    private final LikeService likeService;

    // 게시글 좋아요
    @PostMapping("/post/{postId}")
    public ResponseEntity<String> likePost(@PathVariable Long postId, @RequestParam String userEmail) {
        String response = likeService.likePost(postId, userEmail);  // userName -> userEmail로 수정
        return ResponseEntity.ok(response);
    }

    // 댓글 좋아요
    @PostMapping("/reply/{replyId}")
    public ResponseEntity<String> likeReply(@PathVariable Long replyId, @RequestParam String userEmail) {
        String response = likeService.likeReply(replyId, userEmail);  // userName -> userEmail로 수정
        return ResponseEntity.ok(response);
    }
}
