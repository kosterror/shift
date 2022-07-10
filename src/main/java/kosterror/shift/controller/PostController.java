package kosterror.shift.controller;

import kosterror.shift.dto.NewPostDTO;
import kosterror.shift.dto.PostDTO;
import kosterror.shift.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostDTO create(@RequestBody NewPostDTO newPostDTO) {
        return postService.create(newPostDTO);
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable UUID id) {
        return postService.getPostById(id.toString());
    }

}
