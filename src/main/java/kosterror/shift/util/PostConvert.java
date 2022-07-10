package kosterror.shift.util;

import kosterror.shift.dto.NewPostDTO;
import kosterror.shift.dto.PostDTO;
import kosterror.shift.entity.PostEntity;

import java.util.UUID;

public class PostConvert {

    public static PostEntity NewToEntity(NewPostDTO newPostDTO) {
        return new PostEntity(
                UUID.randomUUID().toString(),
                newPostDTO.getAuthorId(),
                newPostDTO.getTitle(),
                newPostDTO.getText()
        );
    }

    public static PostDTO EntityToDTO(PostEntity postEntity) {
        return new PostDTO(
                postEntity.getUuid().toString(),
                postEntity.getAuthorId(),
                postEntity.getTitle(),
                postEntity.getText()
        );
    }

}
