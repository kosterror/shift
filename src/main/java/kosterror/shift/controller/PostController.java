package kosterror.shift.controller;

import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.PostDTO;
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

}
