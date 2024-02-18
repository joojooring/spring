package lecture.springbootsecurity.controller;


import jakarta.servlet.http.HttpSession;
import lecture.springbootsecurity.dto.UserDTO;
import lecture.springbootsecurity.entity.UserEntity;
import lecture.springbootsecurity.security.TokenProvider;
import lecture.springbootsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j // 로그관련 메소드를 편리하게 쓸 수 있도록 도와주는 기능

public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    TokenProvider tokenProvider;

    @GetMapping("")
    public String getAuth(){
        return "GET/auth";
    }

    @PostMapping("/signup")
//    restful한 api를 만든다는거는 응답객체로써 만들어야 됨 : ResponseEntity<?>
//    - 여기서 ?는 와일드 카드임 : body에 무슨값이 올지 몰라서 어떤 값이 와도 상관 없게 됨
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){

        try { //오류 처리
//       1) save할 때 사용할 userDto로 entity를 생성
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                    .build();

            UserEntity responseUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(responseUser.getEmail())
                    .username(responseUser.getUsername())
                    .id(responseUser.getId())
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(HttpSession session, @RequestBody UserDTO userDTO){
        try{

        UserEntity user = userService.login(userDTO.getEmail(), userDTO.getPassword());

        if(user == null){
            throw new RuntimeException("login failed");
        }

        String token = tokenProvider.createToken(user);


//        응답 객체를 만들기위해서 DTO객체를 만든거임
        UserDTO responseUserDTO = UserDTO.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .id(user.getId())
                .token(token)
                .build();


        return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
