package project.myblog.application.cqrs.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.myblog.application.dto.UserQueryResponse;
import project.myblog.domain.model.User;
import project.myblog.domain.repository.UserRepository;
import project.myblog.presentation.mapper.CQRSMapStructMapper;

@Service
@RequiredArgsConstructor
public class UserQueryHandler {

    private final UserRepository userRepository;
    private final CQRSMapStructMapper cqrsMapStructMapper;

    public UserQueryResponse findUserById(Long id) {
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new IllegalArgumentException("User not found for id: " + id));

        return cqrsMapStructMapper.toUserQueryResponse(user);
    }
}
