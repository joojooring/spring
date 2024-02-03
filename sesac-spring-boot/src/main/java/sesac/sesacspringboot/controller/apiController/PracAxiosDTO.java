package sesac.sesacspringboot.controller.apiController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sesac.sesacspringboot.api.DTO.PracOneDTO;

@Controller
public class PracAxiosDTO {

    @GetMapping("/axios/prac1")
    @ResponseBody
    public String axiosAPI1(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age){
        String msg = "이름 : " + name
                + "\n 나이 : " + age;
        return msg;
    }

    @GetMapping("/axios/prac2")
    @ResponseBody
    public String axiosAPI2(PracOneDTO pracOneDTO){
        String msg = "이름 : " + pracOneDTO.getName()
                + "\n 나이 : " +pracOneDTO.getAge();
        return msg;
    }

    @PostMapping("/axios/prac3")
    @ResponseBody
    public String axiosAPI3(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age){
        String msg = "이름 : " + name
                + "\n 나이 : " + age;
        return msg;
    }

    @PostMapping("/axios/prac4")
    @ResponseBody
    public String axiosAPI4(PracOneDTO pracOneDTO){
//        기본으로 보내는게 ModelAttribute
//        Axios는 기본적으로 json형식으로 데이터를 전송하는데
//        modelAttribute는 json형식은 매핑을 못함!
//        그저 매핑이 안되는거라 null값이 뜨는거임
//        데이터는 전송받아지는데 매핑이 불가능! -> null
        String msg = "이름 : " + pracOneDTO.getName()
                + "\n 나이 : " + pracOneDTO.getAge();
        return msg;
    }

    @PostMapping("/axios/prac5")
    @ResponseBody
    public String axiosAPI5(@RequestBody PracOneDTO pracOneDTO){
        String msg = "이름 : " + pracOneDTO.getName()
                + "\n 나이 : " + pracOneDTO.getAge();
        return msg;
    }
}
