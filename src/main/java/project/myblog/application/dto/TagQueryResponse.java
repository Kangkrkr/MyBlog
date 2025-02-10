package project.myblog.application.dto;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Tag}
 */
@Builder
public record TagQueryResponse(Long id, String name) implements Serializable {
}