package sesac.sesacspringboot.tripjavatest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TouristDTO {
    private String contentid;
    private String contenttypeid;
    private String title;
    private String addr1;
    private String areacode;
    private String sigungucode;
    private String firstimage;
    private String mapx;
    private String mapy;
}
