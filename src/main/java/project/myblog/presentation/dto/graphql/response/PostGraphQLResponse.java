package project.myblog.presentation.dto.graphql.response;

import lombok.Builder;
import project.myblog.domain.code.PostStatus;
import project.myblog.domain.model.Post;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link project.myblog.domain.model.Post}
 */
@Builder
public record PostGraphQLResponse(Long id, String title, String content, UserGraphQLResponse author, PostStatus status,
                                  List<TagGraphQLResponse> tags,
                                  CategoryGraphQLResponse category) implements Serializable {
}