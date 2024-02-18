package lecture.springbootsecurity.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDTO {
    private long id;
    private String username;
    private String email;
    private String password;
    private String token;
}
