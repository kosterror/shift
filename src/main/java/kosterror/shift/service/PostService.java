package kosterror.shift.service;

import kosterror.shift.exeption.PostLikeAlreadyExists;
import kosterror.shift.exeption.PostNotFoundException;
import kosterror.shift.exeption.UserNotFoundException;
import kosterror.shift.model.dto.NewCommentDTO;
import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.NewPostLikeDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.model.entity.CommentEntity;
import kosterror.shift.model.entity.PostEntity;
import kosterror.shift.model.entity.PostLikeEntity;
import kosterror.shift.repository.CommentRepository;
import kosterror.shift.repository.PostLikeRepository;
import kosterror.shift.repository.PostRepository;
import kosterror.shift.repository.UserRepository;
import kosterror.shift.util.PostConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public PostDTO create(NewPostDTO newPostDTO) throws UserNotFoundException {
        if (userRepository.existsById(newPostDTO.getAuthorId())) {
            PostEntity postEntity = PostConvert.NewPostToPostEntity(newPostDTO);
            PostEntity savedPostEntity = postRepository.save(postEntity);

            return PostConvert.PostEntityToPostDTO(savedPostEntity);
        } else {
            throw new UserNotFoundException("User with this ID does not exists.");
        }
    }

    public PostDTO getPostByPostId(String postId) throws PostNotFoundException {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post with this ID does not exists"));
        return PostConvert.PostEntityToPostDTO(postEntity);
    }

    public ArrayList<PostEntity> getAllPostsByIUserId(String userId) {
        return postRepository.findAllByAuthorId(userId);
    }

    public PostLikeEntity like(NewPostLikeDTO newPostLikeDTO) throws PostLikeAlreadyExists, PostNotFoundException, UserNotFoundException {
        //как же мне не нравится эта конструкция...

        if (userRepository.existsById(newPostLikeDTO.getAuthorId())) {
            if (postLikeRepository.existsByAuthorId(newPostLikeDTO.getAuthorId())) {
                if (postRepository.existsById(newPostLikeDTO.getPostId())) {
                    return postLikeRepository.save(PostConvert.NewPostLikeDTOToPostLikeEntity(newPostLikeDTO));
                } else {
                    throw new PostNotFoundException("Post with this ID not found.");
                }
            } else {
                throw new PostLikeAlreadyExists("This user already liked this post.");
            }
        } else {
            throw new UserNotFoundException("User with this ID not found.");
        }
    }

    public ArrayList<PostLikeEntity> getPostLikesByPostId(String postId) {
        return postLikeRepository.getPostLikeEntitiesByPostId(postId);
    }

    public CommentEntity comment(NewCommentDTO newCommentDTO) {
        //TODO: добавить валидацию на сущестование поста, автора коммента и т.д.
        return commentRepository.save(PostConvert.NewCommentDTOToCommentEntity(newCommentDTO));
    }

    public ArrayList<CommentEntity> getAllCommentsByPostId(Long id) {
        return commentRepository.getAllByPostId(id);
    }
}
