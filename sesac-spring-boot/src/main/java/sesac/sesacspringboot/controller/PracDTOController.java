package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sesac.sesacspringboot.DTO.PracOneDTO;
import sesac.sesacspringboot.DTO.UserDto;

//@ResponseBody
//즉, @ResponseBody 어노테이션을 사용하면 해당 메서드의 반환 값은 View가 아닌
// 그 자체로 HTTP 응답의 일부가 됨
//JSON이나 XML과 같은 형식으로 데이터를 반환하는 데 유용
//따라서 @ResponseBody 어노테이션은 메서드의 반환 값을 HTTP 응답 본문으로 사용하고자 할 때 사용되는 스프링의 어노테이션

@Controller
public class PracDTOController {

    @GetMapping("/dto")
    public String getMain(){ return "requestPrac"; }
    @GetMapping("/dto/prac1")
    @ResponseBody
    public String dtoAPI(PracOneDTO pracOneDTO){
        String msg = "이름 : " + pracOneDTO.getName() + "\n 나이 : " + pracOneDTO.getAge();
        return msg;
    }

    @PostMapping("/dto/prac2")
    @ResponseBody
    public String dtoAPI2(PracOneDTO pracOneDTO){
        String msg = "이름 : " + pracOneDTO.getName() + "\n 나이 : " + pracOneDTO.getAge();
        return msg;
    }

    @PostMapping("/dto/prac3")
    @ResponseBody
    public String dtoAPI3(@RequestBody PracOneDTO pracOneDTO){
//        @RequestBody 어노테이션
//        - 요청의 본문에 있는 데이터(req.body)를 읽어와서 객체에 매핑
//        - 여기서 매핑? 필드 값에 값을 주입
//        post로 /dto/prac3 요청시 일반폼전송임


//        일반 폼전송 - DTO (GETTER, SETTER 모두 있는 친구)
//        1,2) 어노테이션 없이 DTO로 받을 경우 & @ModelAttribute DTO로 받을 경우 -> O
//        3) @RequestBody DTO 받을 경우 ->X 오류!

//        일반 폼 전송은 www-x-form-urlencoded 형식이기 때문에
//        get이든 post든 요청의 본문에 데이터가 들어가는게 아닌
//        폼 데이터 형태로 url로 데이터가 전송됨
//        즉, 일반 폼전송은 RequestBody 사용 불가

        String msg = "이름 : " + pracOneDTO.getName() + "\n 나이 : " + pracOneDTO.getAge();
        return msg;
    }
}
