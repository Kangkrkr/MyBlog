package project.myblog.application.cqrs.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.myblog.application.dto.MessageQueryResponse;
import project.myblog.domain.model.Message;
import project.myblog.domain.repository.MessageRepository;
import project.myblog.presentation.mapper.CQRSMapStructMapper;

@Service
@RequiredArgsConstructor
public class MessageCommandHandler {

    private final MessageRepository messageRepository;
    private final CQRSMapStructMapper cqrsMapStructMapper;

    public MessageQueryResponse saveMessage(String content, String sender) {
        Message message = messageRepository.saveMessage(content, sender);

        return cqrsMapStructMapper.toMessageQueryResponse(message);
    }
}
