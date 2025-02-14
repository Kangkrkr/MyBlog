package project.myblog.presentation.query.dto.in;

import project.myblog.domain.code.Role;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.User}
 */
public record UserQueryRequest(Long id, String username, String email, Role role, boolean active) implements Serializable {
}