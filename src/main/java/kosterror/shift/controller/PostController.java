package kosterror.shift.controller;

import io.swagger.v3.oas.annotations.Operation;
import kosterror.shift.exeption.PostLikeAlreadyExists;
import kosterror.shift.exeption.PostNotFoundException;
import kosterror.shift.exeption.UserNotFoundException;
import kosterror.shift.model.dto.NewCommentDTO;
import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.NewPostLikeDTO;
import kosterror.shift.service.PostService;
import kosterror.shift.util.PostConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/remove/{postId}")
    public HttpStatus removePost(@PathVariable String postId) {
        try {
            postService.removePost(postId);

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

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
    public ResponseEntity getAllPostsByIUserId(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(PostConvert.PostEntityToPostDTO(postService.getAllPostsByIUserId(userId)));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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

    @GetMapping("/like/delete/{likeId}")
    @Operation(description = "Удалить лайк с заданным ID")
    public HttpStatus removeLike(@PathVariable String likeId) {
        try {
            postService.removePostLike(likeId);

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }


    @GetMapping("/like/getAll/{postId}")
    @Operation(description = "Получить список всех лайков поста с id = postId. Если пост с заданным ID не сущестует, то придет исключение")
    public ResponseEntity getAllLikesByPostId(@PathVariable String postId) {
        try {
            return ResponseEntity.ok(postService.getPostLikesByPostId(postId));
        } catch (PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/comment/set")
    @Operation(description = "Прокомментировать пост. Если пользователь или пост с заданными ID не существуют, то придет исключение")
    public ResponseEntity comment(@RequestBody NewCommentDTO newCommentDTO) {
        try {
            return ResponseEntity.ok(postService.comment(newCommentDTO));
        } catch (UserNotFoundException | PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/comment/delete/{commentId}")
    @Operation(description = "Удалить комменатрий с заданным ID")
    public HttpStatus removeComment(@PathVariable String commentId) {
        try {
            postService.removeComment(commentId);

            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/comment/getAll/{postId}")
    @Operation(description = "Получить список комментариев поста с id = postId")
    public ResponseEntity getAllCommentsByPostId(@PathVariable String postId) {
        try {
            return ResponseEntity.ok(postService.getAllCommentsByPostId(postId));
        } catch (PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
