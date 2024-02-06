package sesac.sesacspringboot.JPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //class Student() {} // 빈 생성자가 필수로 필요하다.
@NoArgsConstructor // entity가 만들어주는 기본 생성자 : 기본 생성자의 접근 제어자가 불명확함
@Getter
@Builder // 전체 필드가 필요한 생성자가 필요-
//builder를 쓰는 이유는 순서가 상관없이 객체 생성 위해
@AllArgsConstructor

//근데 entity랑 builder랑 같이 쓰게 되면 생성자가 두개가 되어 class 안에 생성자가 하나여야된다는걸 위배
//so, entity에 생성자도 써야된다는 어노테이션이 @NoArgsConstructor고
//    builder에 생성자도 써야된다는 어노테이션 @AllArgsConstructor

@Table(name = "student") //대문자도 사용하고 싶을때
// 데이터베이스의 필드와 변수의 연관관계가 정의된 친구
// db 테이블에 대응되는 하나의 클래스
public class Student {
//    class Student() {} // 빈 생성자가 필수로 필요하다.
//    1. 첫번째 방법

//    primary 키는 @Id 어노테이션을 쓰면 됨
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 를 의미
    private int id;
//    id int primary key auto_increment
//    SEQUENCE 전략? : 새로운 Object를 만들어서 id를 부여하는 방법 (oracle에서 사용, mysql엔 x)
//    TABLE ? : SEQUENCE 전략을 흉내낸거(MuSQL에서도 사용하기 위해) - 모든 DBMS에서 사용 가능

    @Column (name = "name", nullable = false, length = 20)
    private String name;
    //  sql문 : name varchar(20) not null

    @Column(columnDefinition = "TEXT")
    private String nickname;
//    일반 VARCHAR가 아니라 TEXT라는걸 JAVA는 columnDefinition을 통해 알 수 잇음
//    private int age;


//    enum : 여러 개의 상수를 그룹화하여 정의하는 것
    @Column
    @Enumerated(EnumType.STRING)
    private LoginType type;
    public enum LoginType{
//        LoginType이라는 enum은 GOOGLE과 KAKAO라는 두 개의 상수
        GOOGLE, KAKAO
}
}
