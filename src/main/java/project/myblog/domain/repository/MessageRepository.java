package project.myblog.domain.repository;

import org.springframework.stereotype.Repository;
import project.myblog.domain.model.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private final List<Message> messages = new ArrayList<>();

    // Sinks를 통해 새로운 데이터 발생 시 이벤트를 알림
    private final Sinks.Many<Message> messageSink = Sinks.many().multicast().onBackpressureBuffer();

    public List<Message> findAllMessages() {
        return messages;
    }

    public Message saveMessage(String content, String sender) {
        Message message = new Message(String.valueOf(messages.size() + 1), content, sender);
        messages.add(message);
        messageSink.tryEmitNext(message); // 새로운 메시지를 Sink로 emit
        return message;
    }

    public Flux<Message> getMessageStream() {
        return messageSink.asFlux();
    }
}
