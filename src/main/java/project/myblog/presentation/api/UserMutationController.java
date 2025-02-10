//package project.myblog.presentation.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//import project.userservice.application.command.CreateUserCommand;
//import project.userservice.application.command.UserCommandHandler;
//import project.userservice.application.dto.UserResponseDto;
//import project.userservice.application.query.GetUserQuery;
//import project.userservice.application.query.UserQueryHandler;
//import project.userservice.presentation.dto.graphql.UserGraphQLRequest;
//import project.userservice.presentation.dto.graphql.UserGraphQLResponse;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class UserMutationController {
//
//    private final UserQueryHandler userQueryHandler;
//    private final UserCommandHandler userCommandHandler;
//
//    @QueryMapping
//    public UserGraphQLResponse getUser(@Argument Long id) {
//        UserResponseDto userResponseDto = userQueryHandler.getUser(GetUserQuery.builder()
//                                                                               .id(id)
//                                                                               .build());
//        return UserGraphQLResponse.builder()
//                                  .id(userResponseDto.getId())
//                                  .username(userResponseDto.getUsername())
//                                  .email(userResponseDto.getEmail())
//                                  .build();
//    }
//
//    @QueryMapping
//    public List<UserGraphQLResponse> getAllUsers() {
//        return userQueryHandler.getAllUsers()
//                               .stream()
//                               .map(user -> UserGraphQLResponse.builder()
//                                                               .id(user.getId())
//                                                               .username(user.getUsername())
//                                                               .email(user.getEmail())
//                                                               .build())
//                               .toList();
//    }
//
//    // GraphQL의 Mutation: createUser
//    @MutationMapping
//    public UserGraphQLResponse createUser(@Argument UserGraphQLRequest userRequest) {
//        UserResponseDto userResponseDto = userCommandHandler.createUser(CreateUserCommand.builder()
//                                                                                         .name(userRequest.getUsername())
//                                                                                         .email(userRequest.getEmail())
//                                                                                         .password(userRequest.getPassword())
//                                                                                         .build());
//        return UserGraphQLResponse.builder()
//                                  .id(userResponseDto.getId())
//                                  .username(userResponseDto.getUsername())
//                                  .email(userResponseDto.getEmail())
//                                  .build();
//    }
//}