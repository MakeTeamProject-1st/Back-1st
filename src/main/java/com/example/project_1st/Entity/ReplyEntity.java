package com.example.project_1st.Entity;

import com.example.project_1st.dto.ReplyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 설정
    @ToString.Exclude
    @JsonIgnore
    @JoinColumn(name = "post_id") // 외래 키 컬럼 이름을 post_id로 지정
    private PostEntity post; // 댓글이 속한 게시글

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    private String userName;

    private String status;

    @Column(columnDefinition = "TEXT")
    private String content;

    // DTO -> Entity 변환
    public static ReplyEntity toReplyEntity(ReplyDTO replyDTO, PostEntity postEntity) {
        return ReplyEntity.builder()
                .id(replyDTO.getId())
                .content(replyDTO.getContent())
                .userName(replyDTO.getUserName())
                .status(replyDTO.getStatus())
                .post(postEntity) // PostEntity 매핑
                .build();
    }
}
