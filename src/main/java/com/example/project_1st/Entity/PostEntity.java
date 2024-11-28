package com.example.project_1st.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id") // 컬럼 이름을 post_id로 변경
    private Long id; // 게시글 ID

    private String title; // 게시글 제목

    @Column(columnDefinition = "TEXT")
    private String content; // 게시글 내용

    private String author; // 작성자 (예: 사용자 이름)

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // 생성일시

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 수정일시

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ReplyEntity> replies; // 연관된 댓글 리스트
}
