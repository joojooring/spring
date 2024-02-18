package lecture.springbootsecurity.security;
//1)토큰 발급하는 메소드 만들기
//2)토큰 검증하는 메소드 만들기

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lecture.springbootsecurity.config.jwt.JwtProperties;
import lecture.springbootsecurity.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

// => 이 메소드들을 나중에 필요시에 사용하기 위해
@Component
public class TokenProvider {
    @Autowired
    JwtProperties jwtProperties;

//    1.토큰 발급하는 메소드
    public String createToken(UserEntity userEntity){
//        만료날짜 정의 // 현재시간부터 하루 더 늘린다
        Date expireDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey()) //secretKey, 어떤 암호화 방식을 설정할지
                .setSubject(String.valueOf(userEntity.getId())) //사용자에 대한 정보를 넣는 공간 (payload에 들어갈 정보)
                .setIssuer(jwtProperties.getIssuer()) //issuer 받아오기
                .setIssuedAt(new Date()) //언제 발급됐는지 설정
                .setExpiration(expireDate) // 언제 만료할건지 설정
//              위에까지가  JWT 세팅하는 부분
//        아래가 토큰을 만드는 과정
                .compact();
    }


//    2. 토큰 검증하는 메소드 만들기

    public String validateAndGetUserId(String token){
        Claims claims = Jwts.parser()//payload 안에 있는 값을 추출할 때 Claims 타입을 사용
                .setSigningKey(jwtProperties.getSecretKey()) //secretKey 설정
                .parseClaimsJws(token) // 검증할 jwt token을 설정하는 부분
                .getBody();//payload를 가져오는 부분

        return claims.getSubject(); // 위에 setSubject에서 넘겨줬던 값을 가져올 수 있는게 getSubject
    }
}
