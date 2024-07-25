package com.example.hackaton250plusvoicetalk.comments.persist.dto;

import com.example.hackaton250plusvoicetalk.comments.persist.entity.CommentEntity;
import com.example.hackaton250plusvoicetalk.posts.persist.entity.PostEntity;
import com.example.hackaton250plusvoicetalk.user.persist.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentRequest {
    private String content;

    public CommentEntity toEntity(PostEntity post,UserEntity user) {
        return CommentEntity.builder()
                .content(content)
                .post(post)
                .user(user)
                .build();
    }
}
