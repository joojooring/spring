package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller

// @Controller : 해당 클래스가 Controller의 역할을 하는 클래스라는 것을 Spring Container에게 알려줌
//클래스 내부에서 메소드 생성
public class HelloController {

    @GetMapping("/hi")
//    @GetMapping : url을 매핑시켜주는 친구
//    - 클라이언트가 /hi라는 경로로 GET method로 접근한다면 아래 메소드를 실행시켜줌
    public String getHi(Model model){
//        Model : Controller 안의 메서드가 파라미터로 받을 수 있는 객체 중 하나
//        - Model 안에 정보를 담아서 view로 전달
//        -IoC : 개발자가 직접 model을 생성하지 않음!

        model.addAttribute("name","홍길동");
//        model.addAttribute("key","값");
        model.addAttribute("name2","<strong>코딩온</strong>");
        model.addAttribute("age","10");
        model.addAttribute("age2",20);
//        ArrayList<String> items = new ArrayList<>();
        String[] x = {"a", "b", "c", "d", "e"};
        model.addAttribute("item1", x);
        char[] alphabetArray = new char[26];
        char alphabet = 'A';

        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = alphabet;
            alphabet++;
        }
        model.addAttribute("item2", alphabetArray);
        return "hi"; // 템플릿 파일의 이름
//        nodejs로 보면 res.render("hi") 이 작업을 하는건데 hi라는 템플릿 파일이 없기때문에 error발생
//        hi 파일은 resorce 안에 template에 생성
//        res.render("hi", {name : "홍길도"})
    }


    @GetMapping("/person")
    public String getPeople(Model model){
        ArrayList<Person> person = new ArrayList<>();
        person.add(new Person("kim",10));
        person.add(new Person("kim2",10));
        person.add(new Person("kim3",10));
        person.add(new Person("kim4",10));
        model.addAttribute("person", person);

        Person p = new Person("h",11);
        System.out.println(p.getName());
        return "person";
    }


//    @Getter
//    @Setter
//   특정 필드 위에 적으면 거기에 해당하는 필드에 대한 getter setter를 만들겠다는거고
//    class 위에 적으면 class 안에 있는 모든 필드에 대해 getter setter를 만들겠다.

    @Getter
    @Setter
    public class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }
}
