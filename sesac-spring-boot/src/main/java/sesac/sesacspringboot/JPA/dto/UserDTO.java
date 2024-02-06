package sesac.sesacspringboot.JPA.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.format.SignStyle;

@Builder
@Getter
public class UserDTO {
    private String name;
    private String email;
    private int password;
}
