package com.example.project_1st.dto;

import com.example.project_1st.Entity.PostEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PostDTO {

    private Long id; // 게시글 ID
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private String author; // 작성자
    private LocalDateTime createdAt; // 생성일시
    private LocalDateTime updatedAt; // 수정일시
    private List<ReplyDTO> replies; // 댓글 리스트 (DTO 형태로)

    // Entity -> DTO 변환
    public static PostDTO toPostDTO(PostEntity postEntity) {
        return PostDTO.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .author(postEntity.getAuthor())
                .createdAt(postEntity.getCreatedAt())
                .updatedAt(postEntity.getUpdatedAt())
                .replies(postEntity.getReplies() != null
                        ? postEntity.getReplies().stream().map(ReplyDTO::toReplyDTO).toList()
                        : null)
                .build();
    }
}
