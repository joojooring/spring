package lecture.springbootsecurity.repository;

import lecture.springbootsecurity.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);


//   중복된 이메일이 존재하는지에 대한 메소드 생성
    Boolean existsByEmail(String email);


//    로그인하는 로직
    UserEntity findByEmailAndPassword(String email, String password);
}
