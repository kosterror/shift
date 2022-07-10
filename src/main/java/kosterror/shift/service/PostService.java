package kosterror.shift.service;

import kosterror.shift.dto.NewPostDTO;
import kosterror.shift.dto.PostDTO;
import kosterror.shift.entity.PostEntity;
import kosterror.shift.repository.PostRepository;
import kosterror.shift.util.PostConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostDTO create(NewPostDTO newPostDTO) {
        PostEntity postEntity = PostConvert.NewToEntity(newPostDTO);

        PostEntity savedPostEntity = postRepository.save(postEntity);

        return PostConvert.EntityToDTO(savedPostEntity);
    }

    public PostDTO getPostById(String id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        return PostConvert.EntityToDTO(postEntity);
    }
}
