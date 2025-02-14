package project.myblog.presentation.query;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;
import project.myblog.application.query.handler.PostQueryHandler;
import project.myblog.application.query.handler.UserQueryHandler;
import project.myblog.application.query.dto.out.PostQueryResponse;
import project.myblog.application.query.dto.out.UserQueryResponse;
import project.myblog.presentation.query.dto.out.graphql.PostGraphQLQueryResponse;
import project.myblog.presentation.query.dto.out.graphql.UserGraphQLQueryResponse;
import project.myblog.presentation.mapper.GraphQLMapStructMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostGraphQLQueryController {

    private final UserQueryHandler userQueryHandler;
    private final PostQueryHandler postQueryHandler;

    private final GraphQLMapStructMapper graphQLMapStructMapper;

    @QueryMapping
    public PostGraphQLQueryResponse post(@Argument Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }

        PostQueryResponse post = postQueryHandler.findPost(id);

        return graphQLMapStructMapper.toPostGraphQLResponse(post);
    }

    @QueryMapping
    public List<PostGraphQLQueryResponse> posts() {
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
    public UserGraphQLQueryResponse author(PostGraphQLQueryResponse post) {
        UserQueryResponse user = userQueryHandler.findUserById(post.author()
                                                                   .id());

        return graphQLMapStructMapper.toUserGraphQLResponse(user);
    }
}
