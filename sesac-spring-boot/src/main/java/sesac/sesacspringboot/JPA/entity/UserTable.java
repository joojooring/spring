package sesac.sesacspringboot.JPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;

@Entity  //class Student() {} // 빈 생성자가 필수로 필요하다.
@NoArgsConstructor //ENTITY의 기본 생성자
@Getter
//entity는 빈 생성자가 필수
//builder는 전체 필드가 있는 생성자가 필수
//
@Builder
@AllArgsConstructor // Builder 의 전체 필드를 포함한 생성자

public class UserTable {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;
//    create usertable id int primary key auto_increment
//    sequence 전략? 새로운 object를 만들어서 id를 부여하는 방법(oracle에서 사용, mysql에선 사용x)
//    table? sequence 전략을 흉내낸거

    @Column(name = "name", nullable = false, length = 20)
    private String name;
//    create usertable name varchar(20) not null

    @Column(name="email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private int password;

    @Column
    @Enumerated(EnumType.STRING)
    private LoginTypeType type;
    public enum LoginTypeType{
        NAVER, KAKAO, GOOGLE
    }

}
