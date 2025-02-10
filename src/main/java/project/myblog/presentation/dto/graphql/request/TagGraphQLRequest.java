package project.myblog.presentation.dto.graphql.request;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Tag}
 */
public record TagGraphQLRequest(Long id) implements Serializable {
}