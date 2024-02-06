package sesac.sesacspringboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import sesac.sesacspringboot.mybatis.domain.BoardDomain;

import java.util.List;
@Mapper
public interface BoardBoardMapper {
//    sql 작성하거나 xml파일을 작성
//    1) mapper 에는 메소드가 있고, xml에는 없는 경우 -> 실행했을 때 오류
//    2) xml에는 있고, mapper에는 없는 경우 -> 실행자체가 안됨
    List<BoardDomain> getBoardAll(); // 전체 조회 ( select * from board;)
    void insertBoard(BoardDomain boardDomain); // 삽입(insert)

    void patchBoard(BoardDomain boardDomain); // 수정(update)

    void deleteBoard(int id); // 삭제 (delete)

    List<BoardDomain> searchBoard(String word); // 단어 조회 : 이 내용은 xml 파일에 sql문 작성되어야 됨
}
