package kosterror.shift.service;

import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.model.entity.PostEntity;
import kosterror.shift.repository.PostRepository;
import kosterror.shift.util.PostConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostDTO create(NewPostDTO newPostDTO) {
        PostEntity postEntity = PostConvert.NewToEntity(newPostDTO);

        PostEntity savedPostEntity = postRepository.save(postEntity);

        return PostConvert.EntityToDTO(savedPostEntity);
    }

    public PostDTO getPostByPostId(String postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        return PostConvert.EntityToDTO(postEntity);
    }

    public ArrayList<PostEntity> getAllPostsByIUserId(String userId) {
        ArrayList<PostEntity> posts = postRepository.findAllByAuthorId(userId);

        return posts;
    }
}
