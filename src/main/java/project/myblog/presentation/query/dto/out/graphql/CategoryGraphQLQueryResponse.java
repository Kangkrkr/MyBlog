package project.myblog.presentation.query.dto.out.graphql;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Category}
 */
@Builder
public record CategoryGraphQLQueryResponse(Long id, String name, String description) implements Serializable {
}