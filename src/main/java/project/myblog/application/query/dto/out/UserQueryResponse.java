package project.myblog.application.query.dto.out;

import lombok.Builder;
import project.myblog.domain.code.Role;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.User}
 */
@Builder
public record UserQueryResponse(Long id, String username, String email, Role role, boolean active) implements Serializable {
}