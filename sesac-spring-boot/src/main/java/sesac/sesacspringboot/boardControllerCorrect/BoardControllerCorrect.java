package sesac.sesacspringboot.boardControllerCorrect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.sesacspringboot.dto.BoardBoardDTO;
import sesac.sesacspringboot.service.BoardBoardService;
import java.util.List;
@Controller
@RequestMapping("/board/mybatis")
public class BoardControllerCorrect {

    //5개의 메소드
//    1. 전체 조회 -> board.html 랜더링
//    2. 작성 (create) : axios(동적폼전송, post) = @RequestBody로 데이터 받을거임
//    3. 수정(update) : axios(동적폼전송, patch)
//    4. 삭제(delete) : axios(동적폼전송, delete)
//    5. 검색(조회) : axios (동적폼전송, get)


    @Autowired
    BoardBoardService boardBoardService;

//    1. 전체 조회
    @GetMapping ("")
    public String getBoardBoard(Model model){
        List<BoardBoardDTO> result = boardBoardService.getBoardAll();
        model.addAttribute("list", result);
        return "boardboard";
    }

//    2. 작성 (create) : axios(동적폼전송, post) = @RequestBody로 데이터 받을거임
    @PostMapping("") // /board/mybatis
    @ResponseBody // 응답을 보내주기 위해
    public boolean insertBoard(@RequestBody BoardBoardDTO boardBoardDTO) {

        boardBoardService.insertBoard(boardBoardDTO);
        return true;
    }

    @PatchMapping("") // /board/mybatis
    @ResponseBody // 응답 그대로 반환
//    responseBody가 없으면
//    템플릿 파일을 보여주는데 void라면 현재 template을 그대로 다시 보여줌
    public void patchBoard(@RequestBody BoardBoardDTO boardBoardDTO){
        boardBoardService.patchBoard(boardBoardDTO);

    }

    @DeleteMapping("")
    @ResponseBody
    public void deleteBoard(@RequestParam int id){
        boardBoardService.deleteBoard(id);
    }

    @GetMapping("/search") // board/mybatis/search
    @ResponseBody // INT로 받아야되기 때문에 응답결과를 전달받아야되므로
    public int searchBoard(@RequestParam String word){ //?word=
        return boardBoardService.searchBoard(word);
    }

}
