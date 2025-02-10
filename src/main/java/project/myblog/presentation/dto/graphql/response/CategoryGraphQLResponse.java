package project.myblog.presentation.dto.graphql.response;

import lombok.Builder;
import project.myblog.domain.model.Category;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Category}
 */
@Builder
public record CategoryGraphQLResponse(Long id, String name, String description) implements Serializable {
}