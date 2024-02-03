package sesac.sesacspringboot.controller.apiController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sesac.sesacspringboot.api.vo.PractwopostVO;

@Controller
public class PracTwoVOController {

    @GetMapping("/axios")
    public String axiosForm(){
        return "practwopost";
    }


    @PostMapping("/axios/vo")
    @ResponseBody
    public String voMain(@RequestBody PractwopostVO practwopostVO ){
        return practwopostVO.getName() + "님 회원가입 성공하였습니다.";
    }

}
