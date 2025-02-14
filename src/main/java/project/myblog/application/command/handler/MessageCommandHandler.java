package project.myblog.application.command.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.myblog.application.command.dto.out.message.CreateMessageCommandResponse;
import project.myblog.application.query.dto.out.MessageQueryResponse;
import project.myblog.domain.model.Message;
import project.myblog.domain.repository.MessageRepository;
import project.myblog.presentation.mapper.CQRSMapStructMapper;

@Service
@RequiredArgsConstructor
public class MessageCommandHandler {

    private final MessageRepository messageRepository;
    private final CQRSMapStructMapper cqrsMapStructMapper;

    public CreateMessageCommandResponse saveMessage(String content,
                                                    String sender) {
        Message message = messageRepository.saveMessage(content, sender);

        return CreateMessageCommandResponse.builder()
                                           .id(message.getId())
                                           .content(message.getContent())
                                           .sender(message.getSender())
                                           .build();
    }
}
