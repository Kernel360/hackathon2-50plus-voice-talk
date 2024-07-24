package com.example.hackaton250plusvoicetalk.posts.persist;

import com.example.hackaton250plusvoicetalk.posts.persist.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
