package com.example.hackaton250plusvoicetalk.posts.persist.entity;


import com.example.hackaton250plusvoicetalk.comments.persist.entity.CommentEntity;
import com.example.hackaton250plusvoicetalk.common.BaseEntity;
import com.example.hackaton250plusvoicetalk.user.persist.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity(name = "Posts")
@Getter
@Setter
@ToString
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // dto에 not null 추가
    @Column(nullable = false)
    private String title;

    // dto에 not null 추가
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments;
}

