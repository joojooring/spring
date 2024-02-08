package sesac.sesacspringboot.jpaboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sesac.sesacspringboot.jpaboard.entity.BoardEntity;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {


//    title이 일치 or 검색어가 비어있음
//    table 명이 아니라 클래스명을 적으려면 select b임
    @Query("select b from BoardEntity b where (b.title=:word or :word='')")
    List<BoardEntity> searchByWord(String word);
}
