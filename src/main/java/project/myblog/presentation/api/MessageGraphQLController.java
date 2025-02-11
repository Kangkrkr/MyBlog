package project.myblog.presentation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.web.bind.annotation.RestController;
import project.myblog.application.cqrs.command.MessageCommandHandler;
import project.myblog.application.cqrs.query.MessageQueryHandler;
import project.myblog.application.dto.MessageQueryResponse;
import project.myblog.presentation.dto.graphql.response.MessageGraphQLResponse;
import project.myblog.presentation.mapper.GraphQLMapStructMapper;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageGraphQLController {

    private final MessageQueryHandler messageQueryHandler;
    private final MessageCommandHandler messageCommandHandler;
    private final GraphQLMapStructMapper graphQLMapStructMapper;

    // Query: 기존 메시지 리스트 반환
    @QueryMapping
    public List<MessageGraphQLResponse> messages() {
        return messageQueryHandler.findAllMessages()
                                  .stream()
                                  .map(graphQLMapStructMapper::toMessageGraphQLResponse)
                                  .toList();
    }

    // Mutation: 새로운 메시지를 저장
    @MutationMapping
    public MessageGraphQLResponse addMessage(@Argument String content,
                                             @Argument String sender) {
        MessageQueryResponse messageQueryResponse = messageCommandHandler.saveMessage(content, sender);
        return graphQLMapStructMapper.toMessageGraphQLResponse(messageQueryResponse);
    }

    // Subscription: 실시간으로 새 메시지 구독
    @SubscriptionMapping
    public Flux<MessageGraphQLResponse> messageAdded() {
        return messageQueryHandler.getMessageStream()
                                  .map(graphQLMapStructMapper::toMessageGraphQLResponse); // 메시지 스트림 반환
    }
}