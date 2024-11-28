package com.example.project_1st.service;

import com.example.project_1st.Entity.PostEntity;
import com.example.project_1st.Entity.ReplyEntity;
import com.example.project_1st.dto.ReplyDTO;
import com.example.project_1st.repository.PostRepository;
import com.example.project_1st.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository; // 게시글 ID로 PostEntity를 조회하기 위해 필요

    // 댓글 저장 로직
    public ReplyDTO save(ReplyDTO replyDTO) {
        // PostEntity 조회
        Optional<PostEntity> optionalPostEntity = postRepository.findById(replyDTO.getPostId());
        if (optionalPostEntity.isEmpty()) {
            throw new IllegalArgumentException("Invalid post ID: " + replyDTO.getPostId());
        }

        PostEntity postEntity = optionalPostEntity.get();

        // DTO를 Entity로 변환
        ReplyEntity replyEntity = ReplyEntity.toReplyEntity(replyDTO, postEntity);

        // DB에 저장
        ReplyEntity savedEntity = replyRepository.save(replyEntity);

        // Entity -> DTO 변환 후 반환
        return ReplyDTO.toReplyDTO(savedEntity);
    }
}
