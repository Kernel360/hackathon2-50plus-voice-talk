package com.example.hackaton250plusvoicetalk.comments.controller;

import com.example.hackaton250plusvoicetalk.comments.persist.dto.CommentRequest;
import com.example.hackaton250plusvoicetalk.comments.persist.dto.CommentResponse;
import com.example.hackaton250plusvoicetalk.comments.service.CommentService;
import com.example.hackaton250plusvoicetalk.user.web.model.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    // 댓글 추가
    @PostMapping("{user_id}")
    public Api<CommentResponse> create(@RequestBody CommentRequest commentDto, HttpServletRequest request) {

    }

    // 댓글 삭제
    @PatchMapping("{comment_id}/{user_id}")
    public Api<CommentResponse> delete(@RequestBody CommentRequest commentDto, HttpServletRequest request) {

    }

    // 댓글 추가
    @PutMapping("/{user_id}")
    public Api<CommentResponse> update(@RequestBody CommentRequest commentDto) {

    }

    // {post_id} 게시글의 댓글 목록 조회
    @GetMapping("/post/{post_id}")
    public Api<List<CommentResponse>> findByPost(@PathVariable Long post_id) {

    }

    @GetMapping("/list")
    public Api<List<CommentResponse>> findAll() {

    }

}
