package sesac.sesacspringboot.JPA.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CompanyDTO {
    private String name;
    private String position;
    private int number;
}
