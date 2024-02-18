package lecture.springbootsecurity.service;

import lecture.springbootsecurity.entity.UserEntity;
import lecture.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service // service 라는 어노테이션 자체가 @component 어노테이션을 상속받기 때문에 다른데서 autowired로 주입받을 때 사용할 수 있음
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    USER 생성하는 로직
//    1)회원가입 할 떄 사용할 메소드 생성
    public UserEntity create(UserEntity userEntity){
//        이메일이 중복되지 않는 로직 작성
        if(userEntity == null){
            throw new RuntimeException("entity null!!");
        }

//        중복 이메일 불가
        String email = userEntity.getEmail();

//        조회를 하기 위한 레파지토리 생성 필요
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
//        중복 검사 다 했으면 save 하면 됨
        return userRepository.save(userEntity);
    }



//    암호와 없이 로그인하는 로직
//    public UserEntity login(String email, String password){
//        return userRepository.findByEmailAndPassword(email,password);
//    }

//    암호화 적용 후 로그인 로직
    public UserEntity login(String email, String password){
//        1)이메일로 유저를 찾기
        UserEntity searchUser = userRepository.findByEmail(email);
//        암호화된 비밀번호가 db에 저장되어 있다고 가정
        if(searchUser != null && passwordEncoder.matches(password, searchUser.getPassword())){
            return searchUser;
        }
        return null;
    }
}
