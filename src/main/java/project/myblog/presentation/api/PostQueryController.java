package project.myblog.presentation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.myblog.application.cqrs.query.PostQueryHandler;
import project.myblog.application.cqrs.query.UserQueryHandler;
import project.myblog.application.dto.PostQueryResponse;
import project.myblog.application.dto.UserQueryResponse;
import project.myblog.domain.model.User;
import project.myblog.domain.repository.PostRepository;
import project.myblog.domain.repository.UserRepository;
import project.myblog.presentation.dto.graphql.response.PostGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.UserGraphQLResponse;
import project.myblog.presentation.mapper.GraphQLMapStructMapper;

import java.util.List;
import java.util.Optional;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class PostQueryController {

    private final UserQueryHandler userQueryHandler;
    private final PostQueryHandler postQueryHandler;

    private final GraphQLMapStructMapper graphQLMapStructMapper;

    @QueryMapping
    public PostGraphQLResponse post(@Argument Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }

        PostQueryResponse post = postQueryHandler.findPost(id);

        return graphQLMapStructMapper.toPostGraphQLResponse(post);
    }

    @QueryMapping
    public List<PostGraphQLResponse> posts() {
        return postQueryHandler.findPostAll()
                               .stream()
                               .map(graphQLMapStructMapper::toPostGraphQLResponse)
                               .toList();
    }

    /**
     * GraphQL 스키마에서 `PostGraphQLResponse` 타입의 `author` 필드를 매핑합니다.
     * <p>
     * - 스키마 정의:
     * type PostGraphQLResponse {
     * id: ID
     * title: String
     * content: String
     * author: UserQueryResponse
     * }
     * <p>
     * - @SchemaMapping
     * typeName => 스키마의 상위 타입 (예: PostGraphQLResponse)
     * field => 매핑되는 하위 필드 이름 (예: author)
     * <p>
     * 이 메서드는 `PostGraphQLResponse`에 제공된 ID를 사용하여
     * 데이터베이스(`userRepository`)에서 게시글 작성자(author) 정보를 검색함으로써 `author` 필드를 해결합니다.
     * <p>
     * 비고:
     * 1. `typeName`은 GraphQL 스키마에 정의된 타입과 정확히 일치해야 합니다.
     * 2. `field`는 스키마에서 해결할 필드 이름을 나타냅니다.
     * 3. 메서드 이름은 필드 이름과 다를 수 있으며 필드에 제한되지 않습니다.
     */
    @SchemaMapping(typeName = "PostGraphQLResponse", field = "author")
    public UserGraphQLResponse author(PostGraphQLResponse post) {
        UserQueryResponse user = userQueryHandler.findUserById(post.author()
                                                                   .id());

        return graphQLMapStructMapper.toUserGraphQLResponse(user);
    }
}
