package project.myblog.presentation.query.dto.in;

import project.myblog.domain.code.PostStatus;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link project.myblog.domain.model.Post}
 */
public record PostQueryRequest(Long id, String title, String content, UserQueryRequest author, PostStatus status, List<TagQueryRequest> tags,
                               CategoryQueryRequest category) implements Serializable {
}