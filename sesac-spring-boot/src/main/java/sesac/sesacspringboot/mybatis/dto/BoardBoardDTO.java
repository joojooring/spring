package sesac.sesacspringboot.mybatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardBoardDTO {

    private int boardID;
    private String title, content, writer, registered;
    private int no;
}
