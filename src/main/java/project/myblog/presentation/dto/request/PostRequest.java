package project.myblog.presentation.dto.request;

import project.myblog.domain.code.PostStatus;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link project.myblog.domain.model.Post}
 */
public record PostRequest(Long id, String title, String content, UserRequest author, PostStatus status, List<TagRequest> tags,
                          CategoryRequest category) implements Serializable {
}