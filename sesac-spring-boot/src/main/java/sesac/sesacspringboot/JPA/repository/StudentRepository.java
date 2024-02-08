package sesac.sesacspringboot.JPA.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sesac.sesacspringboot.JPA.entity.Student;

import java.util.List;
@Repository
//JpaRepository <대상으로 지정할 엔티티 정의, 해당 엔티티의 pk타입 정의>
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    1. JPA의 기본 규칙을 따르는 방법
//    : findBy 컬럼명 : 그 컬럼명으로 검색을 해줌
//    Student findByName(String name);
    List<Student> findByName(String name); //primary key, unique key로 검색시 findBy로 사용

//    연산자를 사용시 sql 을 일일히 다 작성 안해도 돼서 jpa의 편리한 점임
    List<Student> findByNameAndNickname(String name, String nickname); // and 연산자를 사용시 : 이름과 닉네임이 모두 일치하는 경우
    List<Student> findByNameOrNickname(String name, String nickname); // and 연산자를 사용시 : 이름과 닉네임이 모두 일치하는 경우
    //    findByAgeGreaterThanEqual(int age) // age가 보내진 값보다 크거나 같은 경우

//    =====================실습====================
//    =====================실습====================

//    List<Student> searchPracStudent(String nickname);
    // nickname으로 일치하는 친구의 수를 가져오는 메서드
//    long countByNickname(String nickname);



    @Query("update Student s set s.name = :name where s.id = :id")
    int updateStudentNameById(@Param("name") String name, @Param("id") int id);

//    ====================================

//    2. 직접 Query를 작성해서 연결하는 방법
//    @Query("select s from Student s where s.name = :name") //jpa쿼리
    @Query(nativeQuery = true, value = "select * from student where name = :name") //:name 내가 보낸 파라미터를 콜론으로 받음
//
    List<Student> findTest(String name);



    int countByNickname(String nickname);
}
