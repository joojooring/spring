package sesac.sesacspringboot.mybatis.controllerMyBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.sesacspringboot.mybatis.domain.Board;
import sesac.sesacspringboot.mybatis.dto.BoardDTO;
import sesac.sesacspringboot.mybatis.service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardControllerMyBatis {
    @Autowired
    BoardService boardService;

//    첫 화면 랜더 & 조회
    @GetMapping("")
    public String getBoard(Model model){
        List<Board> posts = boardService.getBoard();
        model.addAttribute("posts",posts);
        return "board";
    }



//    create : 글 작성
//    POST는 Responsebody, RequestBody로 요청 이때 객체로 받을 수 있음
    @PostMapping("/post")
    @ResponseBody
    public String createPost(@RequestBody BoardDTO boardDTO) {
        boardService.createPost(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getWriter());
        return "작성 성공";
    }

// read : 검색어와 일치하는 제목의 게시글 조회
    @GetMapping("/search")
    @ResponseBody
    public int getTitleBoard(@RequestParam String word) {
        List<Board> result = boardService.getTitleBoard(word);
        return result.size();
    }

// update : 게시글 수정
    @PatchMapping("")
    public void updatePost(@RequestBody Board board) {
        // @RequestBody는 객체로 받아야 됨, 필드로 받을시 안됨
        boardService.updatePost(board.getId(), board.getTitle(), board.getContent(), board.getWriter());
    }

// delete : 게시글 삭제
    @DeleteMapping("")
    public void deletePost(@RequestParam int id) {
        boardService.deletePost(id);
    }


}
