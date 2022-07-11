package kosterror.shift.controller;

import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.service.PostService;
import kosterror.shift.util.PostConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public PostDTO create(@RequestBody NewPostDTO newPostDTO) {
        return postService.create(newPostDTO);
    }

    @GetMapping("/get/{id}")
    public PostDTO getPostById(@PathVariable UUID id) {
        return postService.getPostById(id.toString());
    }

    @GetMapping("/getAll/{id}")
    public ArrayList<PostDTO> getAllPostsByIUserId(@PathVariable UUID id) {
        return PostConvert.ListEntityToListDTO(postService.getAllPostsByIUserId(id.toString()));
    }

}
