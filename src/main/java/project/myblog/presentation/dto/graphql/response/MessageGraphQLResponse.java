package project.myblog.presentation.dto.graphql.response;

import lombok.Builder;

@Builder
public record MessageGraphQLResponse(String id, String content, String sender) {
}
