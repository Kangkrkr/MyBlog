package project.myblog.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.myblog.domain.code.PostStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // 포스트 제목
    private String content;     // 포스트 내용, Markdown 또는 HTML 가능

    @ManyToOne  // 하나의 유저는 여러개의 Post 를 작성할 수 있다.
                // `User` 엔티티에서 댓글 목록을 참조하지 않으면(양방향 관계 생략), 복잡성을 줄일 수 있고 불필요한 데이터 로딩도 방지.
    @JoinColumn(name = "author_id") // 작성자 (User와 연관)
    private User author;

    @Enumerated(EnumType.STRING)
    private PostStatus status;  // 상태 (DRAFT, PUBLISHED, DELETED)

    // joda 패키지것을 썼더니 deserialize 오류 남..
    private LocalDateTime createdAt; // 작성 시간
    private LocalDateTime updatedAt; // 수정 시간
    private LocalDateTime publishedAt; // 발행 시간

    @ManyToMany
    @JoinTable(
        name = "post_tags", 
        joinColumns = @JoinColumn(name = "post_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags; // 태그 리스트

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // 카테고리
}