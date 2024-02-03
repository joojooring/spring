package sesac.sesacspringboot.mapper;

import org.apache.ibatis.annotations.*;
import sesac.sesacspringboot.domain.User;

import java.util.List;

//mapper 는 interface로 정의가 되어야 됨 (class 아님)
@Mapper
public interface UserMapper {
//    (sql 문 정의 )or (xml 파일을 읽거나)
//    List<User> retreiveAll();
    List<User> retrieveAll();

//    sql문 정의
//    : insert문

    @Insert("insert into user(name, nickname) values(#{name}, #{nickname})")
    void createUser(String name, String nickname);


    //@Update("UPDATE user SET name = #{name}, nickname = #{nickname} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteUser(int id);
}
