package project.myblog.presentation.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.myblog.application.query.dto.out.category.CategoryQueryResponse;
import project.myblog.application.query.dto.out.MessageQueryResponse;
import project.myblog.application.query.dto.out.PostQueryResponse;
import project.myblog.application.query.dto.out.UserQueryResponse;
import project.myblog.domain.model.Message;
import project.myblog.domain.model.Tag;
import project.myblog.presentation.query.dto.out.graphql.CategoryGraphQLQueryResponse;
import project.myblog.presentation.query.dto.out.graphql.MessageGraphQLQueryResponse;
import project.myblog.presentation.query.dto.out.graphql.PostGraphQLQueryResponse;
import project.myblog.presentation.query.dto.out.graphql.TagGraphQLQueryResponse;
import project.myblog.presentation.query.dto.out.graphql.UserGraphQLQueryResponse;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface GraphQLMapStructMapper {

    UserGraphQLQueryResponse toUserGraphQLResponse(UserQueryResponse user);

    @Mapping(target = "author", source = "author")
    PostGraphQLQueryResponse toPostGraphQLResponse(PostQueryResponse post);

    TagGraphQLQueryResponse toTagGraphQLResponse(Tag tag);
    CategoryGraphQLQueryResponse toCategoryGraphQLResponse(CategoryQueryResponse category);

    MessageGraphQLQueryResponse toMessageGraphQLResponse(MessageQueryResponse message);
    MessageGraphQLQueryResponse toMessageGraphQLResponse(Message message);
}
