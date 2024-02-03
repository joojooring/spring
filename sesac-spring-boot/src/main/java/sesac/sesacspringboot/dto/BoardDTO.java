package sesac.sesacspringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
//  <input type="text" name="title" placeholder="제목" />
//  <input type="text" name="content" placeholder="내용" />
//  <input type="text" name="writer" placeholder="작성자" />
    private int id;
    private String title;
    private String content;
    private String writer;
}
