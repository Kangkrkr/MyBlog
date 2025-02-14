package project.myblog.presentation.query.dto.out.graphql;

import lombok.Builder;

@Builder
public record MessageGraphQLQueryResponse(String id, String content, String sender) {
}
