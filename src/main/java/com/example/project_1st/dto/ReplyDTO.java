package com.example.project_1st.dto;

import com.example.project_1st.Entity.ReplyEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReplyDTO {

    private Long id; // 댓글 ID
    private String content; // 댓글 내용
    private LocalDateTime createdAt; // 생성일
    private String userName; // 작성자 이름
    private String status; // 댓글 상태
    private Long postId; // 게시글 ID (PostEntity의 참조 대신 ID 사용)

    // Entity -> DTO 변환
    public static ReplyDTO toReplyDTO(ReplyEntity replyEntity) {
        return ReplyDTO.builder()
                .id(replyEntity.getId())
                .content(replyEntity.getContent())
                .createdAt(replyEntity.getCreatedAt())
                .userName(replyEntity.getUserName())
                .status(replyEntity.getStatus())
                .postId(replyEntity.getPost().getId()) // PostEntity의 ID
                .build();
    }
}
