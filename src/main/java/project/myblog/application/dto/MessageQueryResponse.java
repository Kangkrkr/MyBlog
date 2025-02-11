package project.myblog.application.dto;

import lombok.Builder;

@Builder
public record MessageQueryResponse(String id,
                                   String content,
                                   String sender) {
}
