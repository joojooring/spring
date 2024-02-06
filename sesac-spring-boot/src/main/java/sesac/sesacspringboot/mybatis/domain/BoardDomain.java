package sesac.sesacspringboot.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDomain {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String registered;
}
