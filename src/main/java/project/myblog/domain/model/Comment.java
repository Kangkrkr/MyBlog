package project.myblog.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // 댓글이 달린 포스트

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author; // 작성자

    private String content; // 댓글 내용
    private LocalDateTime createdAt; // 작성 시간
    private boolean deleted; // 삭제된 댓글 여부
}