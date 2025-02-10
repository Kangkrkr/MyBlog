package project.myblog.presentation.dto.graphql.response;

import lombok.Builder;
import project.myblog.domain.code.Role;
import project.myblog.domain.model.User;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.User}
 */
@Builder
public record UserGraphQLResponse(Long id, String username, String email, Role role,
                                  boolean active) implements Serializable {
}