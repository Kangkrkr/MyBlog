package project.myblog.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // 좋아요 대상이 되는 포스트

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 좋아요를 누른 사용자

    private LocalDateTime createdAt; // 좋아요 등록 시간
}