package kosterror.shift.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPostLikeDTO {
    private String authorId;

    private String postId;

    private Date date;

}
