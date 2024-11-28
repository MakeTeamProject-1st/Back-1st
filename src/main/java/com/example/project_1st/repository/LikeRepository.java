package com.example.project_1st.repository;

import com.example.project_1st.Entity.LikeEntity;
import com.example.project_1st.Entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeEntity, LikeId> {
    // LikeId를 통한 memberEmail 접근
    Optional<LikeEntity> findByPostIdAndLikeIdMemberEmail(Long postId, String memberEmail);
}
