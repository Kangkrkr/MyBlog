package project.myblog.presentation.dto.graphql.request;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Category}
 */
public record CategoryGraphQLRequest(Long id) implements Serializable {
}