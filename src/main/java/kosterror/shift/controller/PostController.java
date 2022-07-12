package kosterror.shift.controller;

import kosterror.shift.model.dto.NewPostDTO;
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
    public PostDTO create(@RequestBody NewPostDTO newPostDTO) {
        return postService.create(newPostDTO);
    }

    @GetMapping("/get/{postId}")
    public PostDTO getPostByPostId(@PathVariable Long postId) {
        return postService.getPostByPostId(postId);
    }

    @GetMapping("/getAll/{userId}")
    public ArrayList<PostDTO> getAllPostsByIUserId(@PathVariable Long userId) {
        return PostConvert.ListEntityToListDTO(postService.getAllPostsByIUserId(userId));
    }

    @PostMapping("/like/set")
    public PostLikeEntity likePost(@RequestBody PostLikeEntity postLikeEntity) {
        return postService.like(postLikeEntity);
    }

    @GetMapping("/like/getAll/{postId}")
    public ArrayList<PostLikeEntity> getAllLikesByPostId(@PathVariable Long postId) {
        return postService.getPostLikesByPostId(postId);
    }

    @PostMapping("/comment/set")
    public CommentEntity comment(@RequestBody CommentEntity commentEntity) {
        return postService.comment(commentEntity);
    }

    @GetMapping("/comment/getAll/{postId}")
    public ArrayList<CommentEntity> getAllCommentsByPostId(@PathVariable Long postId) {
        return postService.getAllCommentsByPostId(postId);
    }

}
