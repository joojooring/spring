package sesac.sesacspringboot.controllerMyBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sesac.sesacspringboot.dto.BoardDTO;
import sesac.sesacspringboot.service.BoardService;
import sesac.sesacspringboot.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller

//@RequestMapping("/board")
//@RestController
public class BoardControllerMyBatis {


    @GetMapping("/board")
    public String getMain(){ return "board"; }
    @Autowired
    BoardService boardService;


//    @GetMapping("/board/search")
//    public int searchBoard(@RequestParam("word") String word) {
//        // 검색어가 있으면 일치하는 제목의 개수를 가져오고
//        // 검색어가 없으면 전체 게시글이 몇 개인지 가져온다.
//        int result;
//        if (word != null && !word.isEmpty()) {
//            result = boardService.getMatchingTitleCount(word);
//        } else {
//            result = boardService.getTotalBoardCount();
//        }
//        return result;
//    }
//@PostMapping("/board/board")
//public List<BoardDTO> createBoard() {
//    // POST 요청 처리 로직 작성
//    List<BoardDTO> result = BoardService.createBoard();
//    return result;
//}


//    @PostMapping("/board")
//    public List<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO) {
//
//
//        // POST 요청 처리 로직 작성
//        boardService.createBoard(title, content, writer);
//        List<BoardDTO> result = boardService.boardAll();
//        return result;
//    }

//    @PostMapping("/board")
//    public String createBoard(@RequestBody BoardDTO boardDTO) {
//        return boardDTO.getTitle() + boardDTO.getContent() + boardDTO.getWriter();
//    }
@PostMapping("/board")
public List<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO) {
    List<BoardDTO> result = new ArrayList<>();
    result.add(boardDTO);
    return result;
}



}
