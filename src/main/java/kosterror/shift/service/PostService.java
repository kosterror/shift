package kosterror.shift.service;

import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.model.entity.CommentEntity;
import kosterror.shift.model.entity.PostEntity;
import kosterror.shift.model.entity.PostLikeEntity;
import kosterror.shift.repository.CommentRepository;
import kosterror.shift.repository.PostLikeRepository;
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
    private final PostLikeRepository postLikeRepository;
    private final CommentRepository commentRepository;

    public PostDTO create(NewPostDTO newPostDTO) {
        PostEntity postEntity = PostConvert.NewToEntity(newPostDTO);

        PostEntity savedPostEntity = postRepository.save(postEntity);

        return PostConvert.EntityToDTO(savedPostEntity);
    }

    public PostDTO getPostByPostId(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        return PostConvert.EntityToDTO(postEntity);
    }

    public ArrayList<PostEntity> getAllPostsByIUserId(Long userId) {
        return postRepository.findAllByAuthorId(userId);
    }

    public PostLikeEntity like(PostLikeEntity postLikeEntity) {
        //TODO: добавить проверку наличия лайка, валидация короче
        return postLikeRepository.save(postLikeEntity);
    }

    public ArrayList<PostLikeEntity> getPostLikesByPostId(Long postId) {
        return postLikeRepository.getPostLikeEntitiesByPostId(postId);
    }

    public CommentEntity comment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    public ArrayList<CommentEntity> getAllCommentsByPostId(Long id) {
        return commentRepository.getAllByPostId(id);
    }
}
