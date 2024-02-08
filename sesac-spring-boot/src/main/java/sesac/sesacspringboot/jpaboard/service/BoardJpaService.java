package sesac.sesacspringboot.jpaboard.service;

import sesac.sesacspringboot.jpaboard.domain.Board;
import sesac.sesacspringboot.jpaboard.dto.BoardDTO;
import sesac.sesacspringboot.jpaboard.entity.BoardEntity;
import sesac.sesacspringboot.jpaboard.mapper.BoardJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesacspringboot.jpaboard.repository.BoardRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BoardJpaService {
//    @Autowired
//    BoardJpaMapper boardMapper;

    @Autowired
    BoardRepository boardRepository;

    public List<BoardDTO> getBoardAll(){
//        List<Board> result = boardMapper.getBoardAll();
//        아래가 jpa 위에가 mybatis
        List<BoardEntity> jpaResult = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<>();



        for(BoardEntity boardEntity : jpaResult){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardID(boardEntity.getId());
            boardDTO.setTitle(boardEntity.getTitle());
            boardDTO.setContent(boardEntity.getContent());
            boardDTO.setWriter(boardEntity.getWriter());
            boardDTO.setRegistered(
                    new SimpleDateFormat("yyyy-mm-dd").format(boardEntity.getRegistered())
            );
//            TIMPSTAMP라서..
//            1. DTO 의 값을 Timestamp 변경
//            2. timestamp -> string 파싱하거나 (SimpleDateFormat) - 내가 원하는 형태로 string형태로 데이터 포맷팅

            boardDTO.setNo(100 + boardEntity.getId());
            boards.add(boardDTO);
        }
//        for ( Board board : result ){
//            BoardDTO boardDTO = new BoardDTO();
//            boardDTO.setBoardID(board.getId());
//            boardDTO.setTitle(board.getTitle());
//            boardDTO.setContent(board.getContent());
//            boardDTO.setWriter(board.getWriter());
//            boardDTO.setRegistered(board.getRegistered());
//            boardDTO.setNo(100 + board.getId());
//            boards.add(boardDTO);
//        }
        return boards;
    }
    public boolean insertBoard(BoardDTO boardDTO) {
//        jpa로는 save() 사용

        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .build();
        boardRepository.save(boardEntity);

//        Board board = new Board();
//        board.setTitle(boardDTO.getTitle());
//        board.setContent(boardDTO.getContent());
//        board.setWriter(boardDTO.getWriter());
//
//        boardMapper.insertBoard(board);
        return true;
    }

    public void patchBoard(BoardDTO boardDTO) {
//        jpa로 없데이트하려면 save() 사용
        System.out.println(boardDTO.getBoardID());
        BoardEntity boardEntity = boardRepository.findById(boardDTO.getBoardID())
                .orElseThrow(()->new NoSuchElementException("board patch : id is wrong"));
        BoardEntity modified = BoardEntity.builder()
                .id(boardEntity.getId())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .registered(boardEntity.getRegistered())
                .build();
        boardRepository.save(modified);



//        // board.getBoardID // title, content, writer
//        Board board = new Board();
//        board.setId(boardDTO.getBoardID()); // update의 where
//        board.setTitle(boardDTO.getTitle());
//        board.setContent(boardDTO.getContent());
//        board.setWriter(boardDTO.getWriter());
//        boardMapper.patchBoard(board);
    }
    public void deleteBoard(int id){
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("board patch : id is wrong"));
        boardRepository.delete(boardEntity);
//        boardRepository.deleteById(id); 바로 삭제해도 됨.. 근데 findbyid로 찾아서 하는게 안전해서 위로 알려준거임


//        boardMapper.deleteBoard(id);
    }

    public int searchBoard(String word) {
        List<BoardEntity> result = boardRepository.searchByWord(word);

//        List<Board> result = boardMapper.searchBoard(word);
        return result.size();
    }
}
