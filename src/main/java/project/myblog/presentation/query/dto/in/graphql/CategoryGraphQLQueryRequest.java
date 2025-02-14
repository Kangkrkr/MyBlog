package project.myblog.presentation.query.dto.in.graphql;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Category}
 */
public record CategoryGraphQLQueryRequest(Long id) implements Serializable {
}