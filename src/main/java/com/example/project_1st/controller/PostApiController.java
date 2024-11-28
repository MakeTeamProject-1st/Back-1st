package com.example.project_1st.controller;

import com.example.project_1st.dto.PostDTO;
import com.example.project_1st.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostApiController {

    private final PostService postService;

    // 게시글 저장
    @PostMapping("/save")
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO postDTO) {
        PostDTO savedPost = postService.save(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable Long id) {
        PostDTO postDTO = postService.findById(id);
        return postDTO != null
                ? ResponseEntity.ok(postDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 모든 게시글 조회
    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.ok("Post deleted successfully");
    }
}
