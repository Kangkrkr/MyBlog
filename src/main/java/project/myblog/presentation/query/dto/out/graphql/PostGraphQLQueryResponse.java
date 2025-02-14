package project.myblog.presentation.query.dto.out.graphql;

import lombok.Builder;
import project.myblog.domain.code.PostStatus;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link project.myblog.domain.model.Post}
 */
@Builder
public record PostGraphQLQueryResponse(Long id, String title, String content, UserGraphQLQueryResponse author, PostStatus status,
                                       List<TagGraphQLQueryResponse> tags,
                                       CategoryGraphQLQueryResponse category) implements Serializable {
}