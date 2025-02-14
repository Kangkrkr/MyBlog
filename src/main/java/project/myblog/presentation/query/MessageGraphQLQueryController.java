package project.myblog.presentation.query;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.web.bind.annotation.RestController;
import project.myblog.application.query.handler.MessageQueryHandler;
import project.myblog.presentation.query.dto.out.graphql.MessageGraphQLQueryResponse;
import project.myblog.presentation.mapper.GraphQLMapStructMapper;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageGraphQLQueryController {

    private final MessageQueryHandler messageQueryHandler;
    private final GraphQLMapStructMapper graphQLMapStructMapper;

    // Query: 기존 메시지 리스트 반환
    @QueryMapping
    public List<MessageGraphQLQueryResponse> messages() {
        return messageQueryHandler.findAllMessages()
                                  .stream()
                                  .map(graphQLMapStructMapper::toMessageGraphQLResponse)
                                  .toList();
    }

    // Subscription: 실시간으로 새 메시지 구독
    @SubscriptionMapping
    public Flux<MessageGraphQLQueryResponse> messageAdded() {
        return messageQueryHandler.getMessageStream()
                                  .map(graphQLMapStructMapper::toMessageGraphQLResponse); // 메시지 스트림 반환
    }
}