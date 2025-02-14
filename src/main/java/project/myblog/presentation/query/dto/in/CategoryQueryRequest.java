package project.myblog.presentation.query.dto.in;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Category}
 */
public record CategoryQueryRequest(Long id, String name, String description) implements Serializable {
}