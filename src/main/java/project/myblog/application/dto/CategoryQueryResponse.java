package project.myblog.application.dto;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.Category}
 */
@Builder
public record CategoryQueryResponse(Long id, String name, String description) implements Serializable {
}