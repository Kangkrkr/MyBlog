package project.myblog.application.query.dto.out;

import lombok.Builder;
import project.myblog.application.query.dto.out.category.CategoryQueryResponse;
import project.myblog.domain.code.PostStatus;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link project.myblog.domain.model.Post}
 */
@Builder
public record PostQueryResponse(Long id, String title, String content, UserQueryResponse author, PostStatus status, List<TagQueryResponse> tags,
                                CategoryQueryResponse category) implements Serializable {
}