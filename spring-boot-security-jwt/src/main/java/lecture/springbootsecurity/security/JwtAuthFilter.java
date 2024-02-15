package lecture.springbootsecurity.security;
//2. Jwt 토큰 기반 인증 방식
// -- 로그인 성공시 -> 서버에서 jwt token 발급 -> token을 응답에 같이 보냄
// -> 응답을 받은 클라이언트는 브라우저에 token 저장 (보통은, localStorage에 저장 - setItem)
// ->  클라이언트에서 로그인이 필요한(인가나 인증이 필요한) 요청을 보낼 때, token을 header의 Auth에 담아서 보냄
// -> 서버에서 요청 객체의 header의 auth 정보에서 token을 가져옴
// -> token이 유효한지 검증
// ->

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
//OncePerRequestFilter 를 상속받게 될 경우 : 요청 당 한 번만 실행한다.
// -> 인가작업에서 이 사람이 유효한지에 대해 한 번만 체크하면 되므로 onceperRequestFilter 사용하는거임
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    TokenProvider tokenProvider;

//    서버에서 요청 객체의 header의 auth 정보에서 token을 가져와서 token이 유효한지 검증
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getBearerToken(request);
            if (token != null && !token.equalsIgnoreCase("null")) {
                String userId = tokenProvider.validateAndGetUserId(token);

                // 1. 사용자 정보를 담는 공간? 토큰 생성
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        String.valueOf(userId), null, AuthorityUtils.NO_AUTHORITIES);

                // 2. SecurityContextHolder 에 authentication 정보 set
                // SecurityContextHolder : 클라이언트의 요청 -> 응답 사이에 일시적으로 auth 정보를 저장할 수 있는 공간
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e){
            log.error("auth error {}!!!!!!!!!!!!!!", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

//    토큰을 헤더에서 가져오는 작업
    public String getBearerToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
//        여기에 들어온 정보가 token뿐만이 아니라 앞에 Bearer라는 문자도 포함되게 됨 이걸 처리해야됨
//        StringUtils.hasText(param ) : param이 null인지 아닌지, 길이가 0보다 큰지 판단
//        bearerToken.startsWith("Bearer ") 첫 문자가 Bearer 로 시작을 하는지
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7); // substring : 7자를 떼어내겠다.
        }
        return null;
    }


//    (payload 값)userid까지 추출하는 작업

}
