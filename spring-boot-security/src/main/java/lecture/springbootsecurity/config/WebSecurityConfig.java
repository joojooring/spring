package lecture.springbootsecurity.config;

import lecture.springbootsecurity.security.CustomAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

// @Configuration:  security 설정 클래스라는 걸 의미
//@EnableWebSecurity : spring security를 사용한다라는걸 의미
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    CustomAuthFilter customAuthFilter;
//    메소드 생성 : SecurityFilterChain
//    우리는 3.x버전

//    암호화!!
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean // spring container에서 관리할 숫 있게끔
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
//        스프링 시큐리티 적용하면, 기본적으로 모든 경로에 인증이 있어야 접근이 가능해짐
//        특정 경로에서 인증 없이 접근 할 수 있도록 설정

        http
                .cors(Customizer.withDefaults())
                .csrf(CsrfConfigurer::disable) // post,put 요청을 허용함 //2.0버전에선 .disabl로 씀
                .logout(auth -> auth
                        .logoutUrl("/auth/logout")
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.setStatus(200);
                        })
                )
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/auth/**") // 이주소에는 인가가 필요없다.
//              .requestMatchers("/admin/**").hasRole("Admin")
                .permitAll() // 다 허가하겠다는 의미

                .anyRequest().authenticated() //나머지 모든 주소는 로그인이 필요하다라는 의미
//                anyRequest 는 제일 마지막에 위치해야 됨
//                .permitAll() : 권한 없이 접속 가능
//                .authenticated() : 로그인 인증이 필요함
//                .hasRole("권한? ex.Admin ") : 일반유저와 어드민과의 차이가 있을 때
//                          - .requestMatchers("/admin/**").hasRole("Admin")

        );
//        UsernamePasswordAuthenticationFilter 다음에 customAuthFilter를 작성하겠다.
//        만들어둔 custom 필터 등록
        http.addFilterAfter(customAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // cors 설정
        config.setAllowCredentials(true); // 실제 응답을 보낼 때, 브라우저에게 자격 증명과 함께 요청을 보낼 수 있도록 허용합니다.
        config.setAllowedOriginPatterns(Arrays.asList("*")); // 모든 원본에서의 요청을 허용합니다.
        config.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE","PUT", "PATCH")); // 허용할 HTTP 메서드를 설정합니다.
        config.setAllowedHeaders(Arrays.asList("*")); // 모든 헤더의 요청을 허용합니다.


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 모든 경로에 대해 위에서 설정한 CORS 설정을 적용합니다.

        return source;
    };



//    우리는 3버전인데 2버전에선 다르게 사용 extends
//     public class WebSecurityConfig extends SecurityConfigurerAdapter(
//
//    }



}
