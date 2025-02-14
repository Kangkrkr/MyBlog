package project.myblog.presentation.query.dto.in.graphql;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Post}
 */
@Builder
public record PostGraphQLQueryRequest(Long id) implements Serializable {
}