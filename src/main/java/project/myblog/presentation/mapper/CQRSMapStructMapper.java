package project.myblog.presentation.mapper;

import org.mapstruct.Mapper;
import project.myblog.application.dto.PostQueryResponse;
import project.myblog.application.dto.UserQueryResponse;
import project.myblog.domain.model.Post;
import project.myblog.domain.model.User;

@Mapper(componentModel = "spring")
public interface CQRSMapStructMapper {

    PostQueryResponse toPostQueryResponse(Post post);

    UserQueryResponse toUserQueryResponse(User user);
}
