package project.myblog.presentation.dto.request;

import project.myblog.domain.code.Role;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.User}
 */
public record UserRequest(Long id, String username, String email, Role role, boolean active) implements Serializable {
}