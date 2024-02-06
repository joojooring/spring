package sesac.sesacspringboot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sesac.sesacspringboot.JPA.entity.Student;

@Repository
//JpaRepository <대상으로 지정할 엔티티 정의, 해당 엔티티의 pk타입 정의>
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
