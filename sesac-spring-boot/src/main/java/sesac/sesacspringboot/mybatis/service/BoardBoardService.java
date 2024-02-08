package sesac.sesacspringboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesacspringboot.mybatis.domain.BoardDomain;
import sesac.sesacspringboot.mybatis.dto.BoardDTO;
import sesac.sesacspringboot.mybatis.mapper.BoardBoardMapper;

import java.util.ArrayList;
import java.util.List;
@Service
public class BoardBoardService {
    @Autowired
    BoardBoardMapper boardBoardMapper;

    public List<BoardDTO> getBoardAll(){
        List<BoardDomain> result =  boardBoardMapper.getBoardAll();
        List<BoardDTO> boards = new ArrayList<>();

        for(BoardDomain board : result){
            BoardDTO boardBoardDTO = new BoardDTO();
            boardBoardDTO.setBoardID(board.getId());
            boardBoardDTO.setTitle(board.getTitle());
            boardBoardDTO.setContent(board.getContent());
            boardBoardDTO.setWriter(board.getWriter());
            boardBoardDTO.setRegistered(board.getRegistered());
            boardBoardDTO.setNo(100 + board.getId());
            boards.add(boardBoardDTO);
        }
        return boards;
    }


    public boolean insertBoard(BoardDTO boardBoardDTO){
        BoardDomain boardDomain = new BoardDomain();
        boardDomain.setTitle(boardBoardDTO.getTitle());
        boardDomain.setContent(boardBoardDTO.getContent());
        boardDomain.setWriter(boardBoardDTO.getWriter());

        boardBoardMapper.insertBoard(boardDomain);
        return true;
    }

    public void patchBoard(BoardDTO boardBoardDTO){
//    board.getBoardID // title,content, wrtier

        BoardDomain boardDomain = new BoardDomain();
        boardDomain.setId(boardBoardDTO.getBoardID());
        boardDomain.setTitle(boardBoardDTO.getTitle());
        boardDomain.setContent(boardBoardDTO.getContent());
        boardDomain.setWriter(boardBoardDTO.getWriter());

        boardBoardMapper.patchBoard(boardDomain);


    }

    public void deleteBoard(int id){
        boardBoardMapper.deleteBoard(id);
    }

    public int searchBoard(String word){
//        처리방법 두가지
//        if(word.equals("")) List <Board> result = boardMapper.get

        List<BoardDomain> result = boardBoardMapper.searchBoard(word);
        return result.size();
    }
}
