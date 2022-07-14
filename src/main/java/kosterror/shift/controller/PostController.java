package kosterror.shift.controller;

import io.swagger.v3.oas.annotations.Operation;
import kosterror.shift.model.dto.NewCommentDTO;
import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.NewPostLikeDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.model.entity.CommentEntity;
import kosterror.shift.model.entity.PostLikeEntity;
import kosterror.shift.service.PostService;
import kosterror.shift.util.PostConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    @Operation(description = "Создание новго поста")
    public PostDTO create(@RequestBody NewPostDTO newPostDTO) {
        return postService.create(newPostDTO);
    }

    @GetMapping("/get/{postId}")
    @Operation(description = "Получить пост с id = postId")
    public PostDTO getPostByPostId(@PathVariable Long postId) {
        return postService.getPostByPostId(postId);
    }

    @GetMapping("/getAll/{userId}")
    @Operation(description = "Получить список постов пользователя с id = userId")
    public ArrayList<PostDTO> getAllPostsByIUserId(@PathVariable Long userId) {
        return PostConvert.PostEntityToPostDTO(postService.getAllPostsByIUserId(userId));
    }

    @PostMapping("/like/set")
    @Operation(description = "Поставить лайк")
    public PostLikeEntity likePost(@RequestBody NewPostLikeDTO newPostLikeDTO) {
        return postService.like(newPostLikeDTO);
    }

    @GetMapping("/like/getAll/{postId}")
    @Operation(description = "Получить список всех лайков поста с id = postId")
    public ArrayList<PostLikeEntity> getAllLikesByPostId(@PathVariable Long postId) {
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
