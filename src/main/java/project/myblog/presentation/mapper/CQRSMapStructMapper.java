package project.myblog.presentation.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.myblog.application.query.dto.out.MessageQueryResponse;
import project.myblog.application.query.dto.out.PostQueryResponse;
import project.myblog.application.query.dto.out.UserQueryResponse;
import project.myblog.domain.model.Message;
import project.myblog.domain.model.Post;
import project.myblog.domain.model.User;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface CQRSMapStructMapper {

    PostQueryResponse toPostQueryResponse(Post post);

    UserQueryResponse toUserQueryResponse(User user);

    MessageQueryResponse toMessageQueryResponse(Message message);
}
