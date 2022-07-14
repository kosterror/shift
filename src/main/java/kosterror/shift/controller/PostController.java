package kosterror.shift.controller;

import io.swagger.v3.oas.annotations.Operation;
import kosterror.shift.exeption.PostLikeAlreadyExists;
import kosterror.shift.exeption.PostNotFoundException;
import kosterror.shift.exeption.UserNotFoundException;
import kosterror.shift.model.dto.NewCommentDTO;
import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.NewPostLikeDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.model.entity.CommentEntity;
import kosterror.shift.model.entity.PostLikeEntity;
import kosterror.shift.service.PostService;
import kosterror.shift.util.PostConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    @Operation(description = "Создание новго поста")
    public ResponseEntity create(@RequestBody NewPostDTO newPostDTO) {
        try {
            return ResponseEntity.ok(postService.create(newPostDTO));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/{postId}")
    @Operation(description = "Получить пост с id = postId")
    public ResponseEntity getPostByPostId(@PathVariable String postId) {
        try {
            return ResponseEntity.ok(postService.getPostByPostId(postId));
        } catch (PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/getAll/{userId}")
    @Operation(description = "Получить список постов пользователя с id = userId")
    public ArrayList<PostDTO> getAllPostsByIUserId(@PathVariable String userId) {
        return PostConvert.PostEntityToPostDTO(postService.getAllPostsByIUserId(userId));
    }

    @PostMapping("/like/set")
    @Operation(description = "Поставить лайк")
    public ResponseEntity likePost(@RequestBody NewPostLikeDTO newPostLikeDTO) {
        try {
            return ResponseEntity.ok(postService.like(newPostLikeDTO));
        } catch (UserNotFoundException | PostLikeAlreadyExists | PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/like/getAll/{postId}")
    @Operation(description = "Получить список всех лайков поста с id = postId")
    public ArrayList<PostLikeEntity> getAllLikesByPostId(@PathVariable String postId) {
        return postService.getPostLikesByPostId(postId);
    }

    @PostMapping("/comment/set")
    @Operation(description = "Прокомментировать пост")
    public CommentEntity comment(@RequestBody NewCommentDTO newCommentDTO) {
        return postService.comment(newCommentDTO);
    }

    @GetMapping("/comment/getAll/{postId}")
    @Operation(description = "Получить список комментариев поста с id = postId")
    public ArrayList<CommentEntity> getAllCommentsByPostId(@PathVariable Long postId) {
        return postService.getAllCommentsByPostId(postId);
    }

}
