package com.example.project_1st.service;

import com.example.project_1st.Entity.LikeEntity;
import com.example.project_1st.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    // 게시글 좋아요 처리
    public String likePost(Long postId, String userEmail) {
        Optional<LikeEntity> existingLike = likeRepository.findByPostIdAndLikeIdMemberEmail(postId, userEmail);
        if (existingLike.isPresent()) {
            return "이미 좋아요를 눌렀습니다.";
        }
        // 좋아요를 추가하는 로직
        // 게시글과 회원 정보를 기반으로 좋아요 엔티티 생성 후 저장
        return "좋아요가 성공적으로 등록되었습니다.";
    }

    // 댓글 좋아요 처리
    public String likeReply(Long replyId, String userEmail) {
        // 댓글 좋아요 로직 구현
        return "댓글에 좋아요가 등록되었습니다.";
    }
}
