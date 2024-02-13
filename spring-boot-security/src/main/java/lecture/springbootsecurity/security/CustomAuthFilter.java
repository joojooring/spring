package lecture.springbootsecurity.security;
//1. 세션 기반 인증 방식
// -- 로그인에 성공 -> session에 userId 저장 : CONTROLLER에서 작성
// -- 다음 요청에서 로그인 여부 판단하고 싶을 때 (클라이언트가 요청을 보낼 때): FILTER에서 작성  -> session에 userId가 있는지 없는지에 따라
// ---- userID가 존재하면, 로그인을 한 사람 / userID가 존재하지 않으면, 로그인을 하지 않은 사람


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//2. jwt token 기반 인증 방식도 해 볼 예정




@Component // bean은 메소드에서 사용하는거고 클래스 관리ㄴ를 spring에서 사용하려면 @component
@Slf4j
public class CustomAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            log.warn("session id !!! {}", session.getId());
//            userId의 존재여부 확인
            Object userId = session.getAttribute("userId");

            if(userId != null){

//                security.core.에 있는 Authentication을 써야 됨
//                사용자 정보를 담는 객체를 만들 때 사용이 되는게  UsernamePasswordAuthenticationToken(식별할 수 있는 값, ...)
//                1) 사용자 정보를 담는 공간인 객체 생성(token 생성)
                Authentication authentication = new UsernamePasswordAuthenticationToken(String.valueOf(userId), null, AuthorityUtils.NO_AUTHORITIES);

//                2) SecurityContextHolder에 사용자의 context를 가져와서 거기에 setAuth를 해서  위에서 만든 객체를 넣어줌
//                SecurityContextHolder: 클라이언트의 요청과 응답 사이에 일시적으로 auth 정보를 저장할 수 있는 공간
                SecurityContextHolder.getContext().setAuthentication(authentication);
//                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
        }catch (Exception e){
            log.error("filter error  {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
