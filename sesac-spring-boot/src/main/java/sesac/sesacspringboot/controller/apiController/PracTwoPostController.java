package sesac.sesacspringboot.controller.apiController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PracTwoPostController {
    @GetMapping("/main")
    public String getPrac(){
        return "practwopost";
    }


    @PostMapping("/mvc-post")
    public  String postPrac(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "month", required = false) String month,
            @RequestParam(value = "day", required = false) String day,
            @RequestParam(value = "interest", required = false) String interest,
            Model model){
        model.addAttribute("name", name);
        model.addAttribute("gender",gender);
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("interest", interest);
        return "practwopostresult";
    }
}
