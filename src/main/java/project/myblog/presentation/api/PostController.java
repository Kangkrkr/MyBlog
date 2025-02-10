package project.myblog.presentation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.myblog.application.cqrs.query.PostQueryHandler;
import project.myblog.application.dto.PostQueryResponse;
import project.myblog.domain.model.Post;
import project.myblog.domain.repository.PostRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class PostController {

    private final PostRepository postRepository;

    private final PostQueryHandler postQueryHandler;

    @GetMapping("/post1")
    public Post getPost() {
        Post post = postRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return post;
    }

    @GetMapping("/post2")
    public PostQueryResponse getPost2() {
        PostQueryResponse queryResponse = postQueryHandler.findPost(1L);
        return queryResponse;
    }

}