package com.example.hackaton250plusvoicetalk.comments.persist;

import com.example.hackaton250plusvoicetalk.comments.persist.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
    List<CommentEntity> findByPost_Id(Long postId);
}
