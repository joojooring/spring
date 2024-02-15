package lecture.springbootsecurity.security;
//2. Jwt 토큰 기반 인증 방식
// -- 로그인 성공시 -> 서버에서 jwt token 발급 -> token을 응답에 같이 보냄
// -> 응답을 받은 클라이언트는 브라우저에 token 저장 (보통은, localStorage에 저장 - setItem)
// ->  클라이언트에서 로그인이 필요한(인가나 인증이 필요한) 요청을 보낼 때, token을 header의 Auth에 담아서 보냄
// -> 서버에서 요청 객체의 header의 auth 정보에서 token을 가져옴
// -> token이 유효한지 검증
// ->

public class JwtAuthFilter {
}
