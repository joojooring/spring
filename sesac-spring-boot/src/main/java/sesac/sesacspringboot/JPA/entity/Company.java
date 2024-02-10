package sesac.sesacspringboot.JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Company {
    @Id //primary key라는걸 뜻하는 롬복
    @GeneratedValue // auto_increment를 나타내는 롬복
    @Column(name = "id", nullable = false) // 컬럼명, value 설정 등 여러 속성을 설정할 수 있는 롬복
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "position", nullable = false, length = 20)
    private String position;
    @Column(name = "number", nullable = false, length = 100)
    private int number;

}
