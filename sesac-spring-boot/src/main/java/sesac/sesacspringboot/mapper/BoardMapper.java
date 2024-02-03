package sesac.sesacspringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sesac.sesacspringboot.domain.Board;

import java.util.List;

@Mapper

public interface BoardMapper {

    List<Board> boardAll();

//    @Insert("insert into user(title, content, writer) values(#{title}, #{content}, #{writer})")
//    void createBoard( String title, String content, String writer);
//    Board getUserById(int id);

    void createBoard(Board board);
}
