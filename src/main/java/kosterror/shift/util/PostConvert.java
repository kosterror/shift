package kosterror.shift.util;

import kosterror.shift.model.dto.NewPostDTO;
import kosterror.shift.model.dto.PostDTO;
import kosterror.shift.model.entity.PostEntity;

import java.util.ArrayList;
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

    public static ArrayList<PostDTO> ListEntityToListDTO(ArrayList<PostEntity> postEntities) {
        ArrayList<PostDTO> postsDTO = new ArrayList<PostDTO>();

        for (int i = 0; i < postEntities.size(); i++) {
            postsDTO.add(PostConvert.EntityToDTO(postEntities.get(i)));
        }

        return postsDTO;
    }

}
