package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PracOneController {
    @GetMapping("/introduce/{name}")
//    @PathVariable 어노테이션은 URL 경로에서 변수 값을 추출하는 데 사용
    public String getIntroduce(@PathVariable("name") String name,
                                Model model){
        model.addAttribute("name",name);
        return "practiceone";
    }


    @GetMapping("/introduce")
//    @RequestParam 어노테이션은 URL의 쿼리 파라미터에서 값을 추출하는 데 사용
//    쿼리 파라미터는 ? 다음에 key=value 형식으로 추가되는 파라미터
    public String getIntroduce(@RequestParam("name") String name,
                               @RequestParam("age") String age,
                               Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "practiceone";
    }
}
