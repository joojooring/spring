package sesac.sesacspringboot.controller.apiController;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;

//@Controller : 해당 클래스가 Controller의 역할을 하는 클래스라는 것을 Spring Container에게 알려줌
//클래스 내부에서 메소드 생성
@Controller
public class TestController {

    @GetMapping("/test")
//    @GetMapping : url을 매핑시켜주는 친구
//    - 클라이언트가 /test라는 경로로 GET method로 접근한다면 아래 메소드를 실행시켜줌

    public String getTest(Model model){
//        Model : Controller 안의 메소드가 파라미터로 받을 수 있는 객체 중 하나!!
//      - model 안에 정보를 담아서 view로 전달
//        -IoC : 개발자가 직접 model을 생성하지 않음!

//        model.addAttribute: "key"와 "value"
        model.addAttribute("name","박박이");
        model.addAttribute("name2", "<strong>빵빵아</strong>");
        model.addAttribute("changeName","송혜교");
        model.addAttribute("age",55);
        model.addAttribute("age2", 5);

        ArrayList<String> person = new ArrayList<>();
        person.add("뿡뿡이");
        person.add("짜잔형");
        model.addAttribute("personperson",person);



//        ////////////////////////////////////실습1
        model.addAttribute("age9",9);
        model.addAttribute("age99",99);


//        return값으로 템플릿 파일의 이름을 넣기!
        return "test";
//        리턴에 적어준 템플릿 파일명이 없으면 rendering이 안되어 error 발생
//        resource 안 template 안에 "test.html"만들기
//        res.render("test", {name: "박박이"});
    }

    @GetMapping("/test2")
    public String getPerson(Model model){
        ArrayList<Person> one =new ArrayList<>();
        one.add(new Person("둘둘이",4));
        one.add(new Person("빌빌이",44));
        one.add(new Person("까시",22));
        one.add(new Person("냥냥이",33));

        model.addAttribute("person",one);

        return "test";
    }
    @Getter
    @Setter
    class Person{
        private String name;
        private int age;

        public Person(String name,int age ){
            this.name=name;
            this.age=age;
        }
    }

}

