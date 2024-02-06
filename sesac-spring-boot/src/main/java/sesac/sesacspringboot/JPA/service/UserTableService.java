package sesac.sesacspringboot.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesacspringboot.JPA.dto.UserDTO;
import sesac.sesacspringboot.JPA.entity.UserTable;
import sesac.sesacspringboot.JPA.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserTableService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getUserAll(){
        List<UserTable> result = userRepository.findAll();
        List<UserDTO> users = new ArrayList<>();

        for (UserTable user : result){
            // 변수 `user`는 `result` 리스트에서 가져온 각 `UserTable` 객체를 참조합니다.

            // UserDTO 객체 생성 및 초기화
            UserDTO userDTO = UserDTO.builder()
                    .name(user.getName()) // 사용자 이름 설정
                    .email(user.getEmail()) // 사용자 이메일 설정
                    .password(user.getPassword()) //사용자 비밀번호 설정
                    .build(); // UserDTO 객체 생성
            users.add(userDTO);// 생성된 UserDTO 객체를 리스트에 추가합니다.

        }
        return users;
    }
}
