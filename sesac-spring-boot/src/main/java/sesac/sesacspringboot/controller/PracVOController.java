package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sesac.sesacspringboot.vo.PracOneVO;

@Controller
public class PracVOController {
    @GetMapping("/vo/prac1")
    @ResponseBody
    public String voAPI1(PracOneVO pracOneVO){
        String msg = "이름 : " + pracOneVO.getName() + "\n 나이 : "+pracOneVO.getAge();
        return msg;
    }//null
//    왜 null? vo는 setter가 없기 때문에 값을 주입해주지 못함. 그래서 값엔 null이 뜸

    @PostMapping("/vo/prac2")
    @ResponseBody
    public String voAPI2(PracOneVO pracOneVO){
        String msg = "이름 : " + pracOneVO.getName() + "\n 나이 : "+pracOneVO.getAge();
        return msg;
    }//null
//    왜 null? vo는 setter가 없기 때문에 값을 주입해주지 못함. 그래서 값엔 null이 뜸


    @PostMapping("/vo/prac3")
    @ResponseBody
    public String voAPI3(@RequestBody PracOneVO pracOneVO){
        String msg = "이름 : " + pracOneVO.getName() + "\n 나이 : "+pracOneVO.getAge();
        return msg;
    }
}
