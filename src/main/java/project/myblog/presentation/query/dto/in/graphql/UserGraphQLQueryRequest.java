package project.myblog.presentation.query.dto.in.graphql;

import lombok.Builder;
import project.myblog.domain.model.User;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.User}
 */
@Builder
public record UserGraphQLQueryRequest(Long id) implements Serializable {

    public static UserGraphQLQueryRequest toGraphQLRequest(User user) {
        return UserGraphQLQueryRequest.builder()
                                      .id(user.getId())
                                      .build();
    }

}