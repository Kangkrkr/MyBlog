package project.myblog.presentation.dto.graphql.response;

import lombok.Builder;
import project.myblog.domain.model.Tag;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Tag}
 */
@Builder
public record TagGraphQLResponse(Long id, String name) implements Serializable {

}