package com.example.hackaton250plusvoicetalk.comments.controller;

import com.example.hackaton250plusvoicetalk.comments.persist.dto.CommentRequest;
import com.example.hackaton250plusvoicetalk.comments.persist.dto.CommentResponse;
import com.example.hackaton250plusvoicetalk.comments.service.CommentService;
import com.example.hackaton250plusvoicetalk.user.web.model.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.hackaton250plusvoicetalk.user.web.model.Api.buildApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    // 댓글 추가
    @PostMapping("/{post_id}/{user_id}")
    public Api<CommentResponse> create(
            @RequestBody Api<CommentRequest> commentDto,
            @PathVariable(value = "post_id") Long postId,
            @PathVariable(value = "user_id") Long userId
    ) {
        return Api.buildApiResponse(HttpStatus.OK, commentService.save(commentDto.getData(),postId,userId));
    }

    // 댓글 삭제
    @PatchMapping("{comment_id}/{user_id}")
    public Api<CommentResponse> delete(
            @PathVariable(value = "comment_id") Long commentId,
            @PathVariable(value = "user_id") Long userId
    ) {
        Optional<CommentResponse> target = commentService.delete(commentId, userId);
        return target.map(commentResponse -> buildApiResponse(HttpStatus.OK, commentResponse))
                .orElseGet(() -> buildApiResponse(HttpStatus.BAD_REQUEST, null));
    }

    // 댓글 수정
    @PutMapping("/{comment_id}/{user_id}")
    public Api<CommentResponse> update(
            @RequestBody Api<CommentRequest> commentDto,
            @PathVariable(value = "comment_id") Long commentId,
            @PathVariable(value = "user_id") Long userId
    ) {
        Optional<CommentResponse> target = commentService.update(commentDto.getData(), commentId, userId);
        return target.map(commentResponse -> buildApiResponse(HttpStatus.OK, commentResponse))
                .orElseGet(() -> buildApiResponse(HttpStatus.BAD_REQUEST, null));
    }

    // {post_id} 게시글의 댓글 목록 조회
    @GetMapping("/post/{post_id}")
    public Api<List<CommentResponse>> findByPost(@PathVariable Long post_id) {
        return Api.buildApiResponse(HttpStatus.OK,commentService.findByPostId(post_id));
    }

    @GetMapping("/list")
    public Api<List<CommentResponse>> findAll() {
        return Api.buildApiResponse(HttpStatus.OK, commentService.findAll());
    }

}
