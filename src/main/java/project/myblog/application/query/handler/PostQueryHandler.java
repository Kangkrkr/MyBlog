package project.myblog.application.query.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.myblog.application.query.dto.out.PostQueryResponse;
import project.myblog.domain.model.Post;
import project.myblog.domain.repository.PostRepository;
import project.myblog.presentation.mapper.CQRSMapStructMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryHandler {

    private final PostRepository postRepository;
    private final CQRSMapStructMapper cqrsMapStructMapper;

    public PostQueryResponse findPost(Long id) {
        Post post = postRepository.findById(id)
                                  .orElseThrow(() -> new IllegalArgumentException("Post not found for id: " + id));


        return cqrsMapStructMapper.toPostQueryResponse(post);
    }

    public List<PostQueryResponse> findPostAll() {
        return postRepository.findAll()
                             .stream()
                             .map(cqrsMapStructMapper::toPostQueryResponse)
                             .toList();
    }
}
