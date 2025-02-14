package project.myblog.presentation.query.dto.out.graphql;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Tag}
 */
@Builder
public record TagGraphQLQueryResponse(Long id, String name) implements Serializable {

}