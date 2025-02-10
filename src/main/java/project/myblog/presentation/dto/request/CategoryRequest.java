package project.myblog.presentation.dto.request;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Category}
 */
public record CategoryRequest(Long id, String name, String description) implements Serializable {
}