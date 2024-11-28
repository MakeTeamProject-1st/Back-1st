package com.example.project_1st.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LikeEntity {

    @EmbeddedId
    private LikeId likeId;  // 복합 키를 포함하는 객체

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)  // 외래 키 컬럼 이름을 명확히 지정
    private PostEntity post;  // 실제 PostEntity와의 관계

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_email", insertable = false, updatable = false)  // 외래 키 컬럼 이름을 명확히 지정
    private MemberEntity member;  // 실제 MemberEntity와의 관계

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")  // `ReplyEntity`와의 관계를 추가 (외래 키 컬럼을 `reply_id`로 지정)
    private ReplyEntity reply; // 댓글이 속한 게시글에 대한 참조

    public LikeEntity(PostEntity post, MemberEntity memberEntity, ReplyEntity replyEntity) {
        this.post = post;
        this.member = memberEntity;
        this.reply = replyEntity; // 복합 키 객체를 생성할 때 댓글을 매핑
    }
}
