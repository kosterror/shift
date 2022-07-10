package kosterror.shift.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String uuid;

    private String authorId;

    private String title;

    private String text;

}
