package project.myblog.application.cqrs.query;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.myblog.application.dto.CategoryQueryResponse;
import project.myblog.application.dto.PostQueryResponse;
import project.myblog.application.dto.TagQueryResponse;
import project.myblog.application.dto.UserQueryResponse;
import project.myblog.domain.model.Category;
import project.myblog.domain.model.Post;
import project.myblog.domain.model.Tag;
import project.myblog.domain.model.User;
import project.myblog.domain.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryHandler {

    private final PostRepository postRepository;

    public PostQueryResponse getPost(Long id) {
        Post foundPost = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found for id: " + id));

        User author = foundPost.getAuthor();
        List<Tag> tags = foundPost.getTags();
        Category category = foundPost.getCategory();

        return PostQueryResponse.builder()
                                .id(foundPost.getId())
                                .title(foundPost.getTitle())
                                .content(foundPost.getContent())
                                .author(UserQueryResponse.builder()
                                                         .id(author.getId())
                                                         .build())
                                .status(foundPost.getStatus())
                                .tags(tags
                                        .stream()
                                        .map(tag -> TagQueryResponse.builder()
                                                                    .id(tag.getId())
                                                                    .name(tag.getName())
                                                                    .build())
                                        .toList())
                                .category(CategoryQueryResponse.builder()
                                                               .id(category.getId())
                                                               .name(category.getName())
                                                               .build())
                                .build();
    }
}
