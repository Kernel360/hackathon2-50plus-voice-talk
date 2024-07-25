package com.example.hackaton250plusvoicetalk.comments.persist;

import com.example.hackaton250plusvoicetalk.comments.persist.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
}
