package com.example.hackaton250plusvoicetalk.comments.service;

import com.example.hackaton250plusvoicetalk.comments.persist.CommentRepository;
import com.example.hackaton250plusvoicetalk.comments.persist.dto.CommentRequest;
import com.example.hackaton250plusvoicetalk.comments.persist.dto.CommentResponse;
import com.example.hackaton250plusvoicetalk.comments.persist.entity.CommentEntity;
import com.example.hackaton250plusvoicetalk.posts.persist.PostRepository;
import com.example.hackaton250plusvoicetalk.posts.persist.entity.PostEntity;
import com.example.hackaton250plusvoicetalk.user.persist.UserRepository;
import com.example.hackaton250plusvoicetalk.user.persist.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentResponse save(CommentRequest commentDto, Long postId, Long userId) {
        PostEntity post = postRepository.findById(postId).get();
        UserEntity user = userRepository.findByUserId(userId).get();
        CommentEntity comment = commentDto.toEntity(post,user);
        return CommentResponse.toDto(commentRepository.save(comment));
    }

    public Optional<CommentResponse> delete(Long commentId, Long userId) {
        Optional<CommentEntity> target = commentRepository.findById(commentId);
        if (target.isPresent()) {
            CommentEntity comment = target.get();
            if (Objects.equals(comment.getUser().getUserId(), userId)) {
                commentRepository.delete(comment);
                return Optional.of(CommentResponse.toDto(comment));
            }
        }
        return Optional.empty();
    }

    public Optional<CommentResponse> update(CommentRequest commentDto, Long commentId, Long userId) {
        Optional<CommentEntity> target = commentRepository.findById(commentId);
        if (target.isPresent()) {
            CommentEntity comment = target.get();
            if (Objects.equals(comment.getUser().getUserId(), userId)) {
                comment.setContent(commentDto.getContent());
                return Optional.of(CommentResponse.toDto(commentRepository.save(comment)));
            }
        }
        return Optional.empty();
    }

    public List<CommentResponse> findByPostId(Long postId) {
        return commentRepository.findByPost_Id(postId).stream()
                .map(CommentResponse::toDto)
                .toList();
    }

    public List<CommentResponse> findAll() {
        return commentRepository.findAll().stream()
                .map(CommentResponse::toDto)
                .toList();
    }
}
