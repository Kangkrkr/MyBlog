package project.myblog.presentation.dto.graphql.request;

import lombok.Builder;
import project.myblog.domain.code.PostStatus;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link project.myblog.domain.model.Post}
 */
@Builder
public record PostGraphQLRequest(Long id) implements Serializable {
}