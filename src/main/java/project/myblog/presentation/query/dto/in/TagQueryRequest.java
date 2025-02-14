package project.myblog.presentation.query.dto.in;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Tag}
 */
public record TagQueryRequest(Long id, String name) implements Serializable {
}