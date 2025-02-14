package project.myblog.application.query.dto.out;

import lombok.Builder;

@Builder
public record MessageQueryResponse(String id,
                                   String content,
                                   String sender) {
}
