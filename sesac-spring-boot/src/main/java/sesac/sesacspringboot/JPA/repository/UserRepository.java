package sesac.sesacspringboot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.sesacspringboot.JPA.entity.UserTable;

@Repository
// Entity에 의해 생성된 DB에 접근하는 메소드를 사용하기 위한 인터페이스

public interface UserRepository extends JpaRepository <UserTable, Integer> {
    // JpaRepository를 상속받으면 기본적인 DB 접근 메소드를 사용
//    JpaRepository <대상으로 지정할 엔티티 정의, 엔티티의 pk타입 정의>
}
