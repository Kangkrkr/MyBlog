package project.myblog.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.myblog.application.dto.CategoryQueryResponse;
import project.myblog.application.dto.PostQueryResponse;
import project.myblog.application.dto.UserQueryResponse;
import project.myblog.domain.model.Tag;
import project.myblog.presentation.dto.graphql.response.CategoryGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.PostGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.TagGraphQLResponse;
import project.myblog.presentation.dto.graphql.response.UserGraphQLResponse;

@Mapper(componentModel = "spring")
public interface GraphQLMapStructMapper {

    UserGraphQLResponse toUserGraphQLResponse(UserQueryResponse user);

    @Mapping(target = "author", source = "author")
    PostGraphQLResponse toPostGraphQLResponse(PostQueryResponse post);

    TagGraphQLResponse toTagGraphQLResponse(Tag tag);
    CategoryGraphQLResponse toCategoryGraphQLResponse(CategoryQueryResponse category);
}
