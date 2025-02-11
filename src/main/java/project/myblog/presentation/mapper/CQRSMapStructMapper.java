package project.myblog.presentation.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.myblog.application.dto.MessageQueryResponse;
import project.myblog.application.dto.PostQueryResponse;
import project.myblog.application.dto.UserQueryResponse;
import project.myblog.domain.model.Message;
import project.myblog.domain.model.Post;
import project.myblog.domain.model.User;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface CQRSMapStructMapper {

    @Mapping(target = "author", source = "author")
    PostQueryResponse toPostQueryResponse(Post post);

    UserQueryResponse toUserQueryResponse(User user);

    MessageQueryResponse toMessageQueryResponse(Message message);
}
