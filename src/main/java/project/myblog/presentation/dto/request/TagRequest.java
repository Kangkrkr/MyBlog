package project.myblog.presentation.dto.request;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Tag}
 */
public record TagRequest(Long id, String name) implements Serializable {
}