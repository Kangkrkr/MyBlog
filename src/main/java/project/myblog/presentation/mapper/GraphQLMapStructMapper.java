package project.myblog.presentation.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.myblog.application.dto.CategoryQueryResponse;
import project.myblog.application.dto.MessageQueryResponse;
import project.myblog.application.dto.PostQueryResponse;
import project.myblog.application.dto.UserQueryResponse;
import project.myblog.domain.model.Message;
import project.myblog.domain.model.Tag;
import project.myblog.presentation.dto.graphql.response.CategoryGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.MessageGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.PostGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.TagGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.UserGraphQLResponse;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface GraphQLMapStructMapper {

    UserGraphQLResponse toUserGraphQLResponse(UserQueryResponse user);

    @Mapping(target = "author", source = "author")
    PostGraphQLResponse toPostGraphQLResponse(PostQueryResponse post);

    TagGraphQLResponse toTagGraphQLResponse(Tag tag);
    CategoryGraphQLResponse toCategoryGraphQLResponse(CategoryQueryResponse category);

    MessageGraphQLResponse toMessageGraphQLResponse(MessageQueryResponse message);
    MessageGraphQLResponse toMessageGraphQLResponse(Message message);
}
