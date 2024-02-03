package sesac.sesacspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesacspringboot.domain.Board;
import sesac.sesacspringboot.domain.User;
import sesac.sesacspringboot.dto.BoardDTO;
import sesac.sesacspringboot.dto.UserDTO;
import sesac.sesacspringboot.mapper.BoardMapper;
import sesac.sesacspringboot.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public List<BoardDTO> boardAll(){
//        retrieveALL은 CONTROLLER에서 호출하는 메소드
//        usermapper의 retrieveAll을 실행한 후 받아온 List<User>
//        List<UserDTO>에 담아서 반환

        List<Board> boards = boardMapper.boardAll();
        List<BoardDTO> result = new ArrayList<>();


//        for문을 이용해서  List<User> ->  List<UserDTO>
        for(Board board : boards){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setTitle(board.getTitle());
            boardDTO.setContent(board.getContent());
            boardDTO.setWriter(board.getWriter());

            result.add(boardDTO);
        }

        return result;
    }

//    public void createBoard(String title, String content, String writer){
//        boardMapper.createBoard(title,content,writer);
//
//    }
public void createBoard(String title, String content, String writer) {
    Board board = new Board();
    board.setTitle(title);
    board.setContent(content);
    board.setWriter(writer);

    System.out.println("------------------------"+title);
    System.out.println(content);
    System.out.println(writer);
    boardMapper.createBoard(board);
}

}
