package project.myblog.presentation.query.dto.in.graphql;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Tag}
 */
public record TagGraphQLQueryRequest(Long id) implements Serializable {
}