package com.example.hackaton250plusvoicetalk.comments.persist.dto;

import com.example.hackaton250plusvoicetalk.comments.persist.entity.CommentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentResponse {
    private String content;
    private Long userId;
    private String username;
    private Long postId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static CommentResponse toDto(CommentEntity comment) {
        return CommentResponse.builder()
                .content(comment.getContent())
                .userId(comment.getUser().getUserId())
                .username(comment.getUser().getUsername())
                .postId(comment.getPost().getId())
                .createdDate(comment.getCreatedDate())
                .modifiedDate(comment.getModifiedDate())
                .build();
    }
}
