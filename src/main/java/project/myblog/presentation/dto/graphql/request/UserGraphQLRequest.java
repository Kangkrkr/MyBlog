package project.myblog.presentation.dto.graphql.request;

import lombok.Builder;
import lombok.Getter;
import project.myblog.domain.code.Role;
import project.myblog.domain.model.User;

import java.io.Serializable;

/**
 * DTO for {@link project.myblog.domain.model.User}
 */
@Builder
public record UserGraphQLRequest(Long id) implements Serializable {

    public static UserGraphQLRequest toGraphQLRequest(User user) {
        return UserGraphQLRequest.builder()
                                 .id(user.getId())
                                 .build();
    }

}