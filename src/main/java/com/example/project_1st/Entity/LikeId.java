package com.example.project_1st.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikeId implements Serializable {

    @Column(name = "post_id") // 컬럼 이름을 지정
    private Long postId; // 게시글 ID (BIGINT)

    @Column(name = "member_email") // 컬럼 이름을 지정
    private String memberEmail; // 회원 이메일

    // 기본 생성자
    public LikeId() {}

    // 생성자
    public LikeId(Long postId, String memberEmail) {
        this.postId = postId;
        this.memberEmail = memberEmail;
    }

    // equals()와 hashCode() 메서드를 정의하여 복합키 비교를 할 수 있도록 합니다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeId likeId = (LikeId) o;
        return postId.equals(likeId.postId) && memberEmail.equals(likeId.memberEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, memberEmail);
    }
}
