package kosterror.shift.util;

import kosterror.shift.dto.NewPostDTO;
import kosterror.shift.dto.PostDTO;
import kosterror.shift.entity.PostEntity;

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

    public static ArrayList<PostDTO> ListEntityToListDTO(ArrayList<PostEntity> posts) {
        ArrayList<PostDTO> postEntities = new ArrayList<PostDTO>();

        for (int i = 0; i < posts.size(); i++) {
            postEntities.add(PostConvert.EntityToDTO(posts.get(i)));
        }

        return postEntities;
    }

}
