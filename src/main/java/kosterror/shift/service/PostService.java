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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, PostLikeRepository postLikeRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.postLikeRepository = postLikeRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

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

    public ArrayList<PostEntity> getAllPostsByIUserId(String userId) throws UserNotFoundException {
        if (userRepository.existsById(userId)) {
            return postRepository.findAllByAuthorId(userId);
        } else {
            throw new UserNotFoundException("User with this ID does not exists");
        }
    }

    public PostLikeEntity like(NewPostLikeDTO newPostLikeDTO) throws PostLikeAlreadyExists, PostNotFoundException, UserNotFoundException {
        //пока не придумал как убрать этот ддос бд

        if (userRepository.existsById(newPostLikeDTO.getAuthorId())) {
            if (!postLikeRepository.existsByAuthorIdAndPostId(newPostLikeDTO.getAuthorId(), newPostLikeDTO.getPostId())) {
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

    public ArrayList<PostLikeEntity> getPostLikesByPostId(String postId) throws PostNotFoundException {
        if (postRepository.existsById(postId)) {
            return postLikeRepository.getPostLikeEntitiesByPostId(postId);
        } else {
            throw new PostNotFoundException("Post with this ID not found");
        }
    }

    public CommentEntity comment(NewCommentDTO newCommentDTO) throws UserNotFoundException, PostNotFoundException {
        if (userRepository.existsById(newCommentDTO.getAuthorId())) {
            if (postRepository.existsById(newCommentDTO.getPostId())) {
                return commentRepository.save(PostConvert.NewCommentDTOToCommentEntity(newCommentDTO));
            } else {
                throw new PostNotFoundException("Post with this ID not found");
            }
        } else {
            throw new UserNotFoundException("User with this ID does not exists");
        }
    }

    public ArrayList<CommentEntity> getAllCommentsByPostId(String id) throws PostNotFoundException {
        if (postRepository.existsById(id)) {
            return commentRepository.getAllByPostId(id);
        } else {
            throw new PostNotFoundException("Post with this ID does not exists");
        }
    }

    public void deletePostLike(String postLikeId) {
        postLikeRepository.deleteById(postLikeId);
    }

    public void deleteAllLikes(String postId) {
        postLikeRepository.deleteAllByPostId(postId);
    }

    public void deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
    }

    public void deleteAllComments(String postId) {
        commentRepository.deleteAllByPostId(postId);
    }

    public void deletePost(String postId) {
        deleteAllLikes(postId);
        deleteAllComments(postId);

        postRepository.deleteById(postId);
    }
}
