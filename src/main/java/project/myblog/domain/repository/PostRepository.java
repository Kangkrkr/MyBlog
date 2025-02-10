package project.myblog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.myblog.domain.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostById(Long id);

    List<Post> findPostByAuthorId(Long id);
}
