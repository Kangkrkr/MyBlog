package project.myblog.application.cqrs.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.myblog.application.dto.MessageQueryResponse;
import project.myblog.domain.model.Message;
import project.myblog.domain.repository.MessageRepository;
import project.myblog.presentation.mapper.CQRSMapStructMapper;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageQueryHandler {

    private final MessageRepository messageRepository;
    private final CQRSMapStructMapper cqrsMapStructMapper;

    public List<MessageQueryResponse> findAllMessages() {
        return messageRepository.findAllMessages()
                                .stream()
                                .map(cqrsMapStructMapper::toMessageQueryResponse)
                                .toList();
    }

    public Flux<Message> getMessageStream() {
        return messageRepository.getMessageStream();
    }
}
