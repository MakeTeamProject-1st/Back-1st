package com.example.project_1st.service;

import com.example.project_1st.Entity.PostEntity;
import com.example.project_1st.dto.PostDTO;
import com.example.project_1st.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시글 저장
    public PostDTO save(PostDTO postDTO) {
        PostEntity postEntity = PostEntity.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .author(postDTO.getAuthor())
                .build();
        PostEntity savedEntity = postRepository.save(postEntity);
        return PostDTO.toPostDTO(savedEntity);
    }

    // 게시글 조회 (ID로 조회)
    public PostDTO findById(Long id) {
        Optional<PostEntity> optionalPost = postRepository.findById(id);
        return optionalPost.map(PostDTO::toPostDTO).orElse(null);
    }

    // 모든 게시글 조회
    public List<PostDTO> findAll() {
        return postRepository.findAll().stream()
                .map(PostDTO::toPostDTO)
                .toList();
    }

    // 게시글 삭제
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
