package lecture.springbootsecurity.config.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt")
// 자바 클래스에 프로퍼티 값(application.properties 파일 참고)을 가져와서 jwt 관련속성을 참고하여,
// 해당 클래스의 필드 값을 사용하는 어노테이션
public class JwtProperties {
    private String issuer;
    private String secretKey;


}
