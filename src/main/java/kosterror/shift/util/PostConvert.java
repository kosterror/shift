package kosterror.shift.util;

import kosterror.shift.model.dto.NewCommentDTO;
import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.NewPostLikeDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.model.entity.CommentEntity;
import kosterror.shift.model.entity.PostEntity;
import kosterror.shift.model.entity.PostLikeEntity;

import java.util.ArrayList;
import java.util.UUID;

public class PostConvert {

    public static PostEntity NewPostToPostEntity(NewPostDTO newPostDTO) {
        return new PostEntity(
                UUID.randomUUID().toString(),
                newPostDTO.getAuthorId(),
                newPostDTO.getTitle(),
                newPostDTO.getText()
        );
    }

    public static PostDTO PostEntityToPostDTO(PostEntity postEntity) {
        return new PostDTO(
                postEntity.getId(),
                postEntity.getAuthorId(),
                postEntity.getTitle(),
                postEntity.getText()
        );
    }

    public static ArrayList<PostDTO> PostEntityToPostDTO(ArrayList<PostEntity> postEntities) {
        ArrayList<PostDTO> postsDTO = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            postsDTO.add(PostConvert.PostEntityToPostDTO(postEntity));
        }

        return postsDTO;
    }

    public static CommentEntity NewCommentDTOToCommentEntity(NewCommentDTO newCommentDTO) {
        return new CommentEntity(
                UUID.randomUUID().toString(),
                newCommentDTO.getAuthorId(),
                newCommentDTO.getPostId(),
                newCommentDTO.getDate(),
                newCommentDTO.getText()
        );
    }

    public static PostLikeEntity NewPostLikeDTOToPostLikeEntity(NewPostLikeDTO newPostLikeDTO) {
        return new PostLikeEntity(
                UUID.randomUUID().toString(),
                newPostLikeDTO.getAuthorId(),
                newPostLikeDTO.getPostId(),
                newPostLikeDTO.getDate()
        );
    }

}
