package sesac.sesacspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {


    @GetMapping("/people")
    public String personList(Model model){
        ArrayList<Person> personList = new ArrayList<>();

        Person person1 = new Person("kim",10);
        Person person2 = new Person("lee",20);
        Person person3 = new Person("hong",30);
        Person person4 = new Person("park",40);
        Person person5 = new Person("shin",50);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        model.addAttribute("personList",personList);
//        model.addAttribute("name1", person1.getName());
//        model.addAttribute("age1", person1.getAge());
//
//        model.addAttribute("name2", person2.getName());
//        model.addAttribute("age2", person2.getAge());
//
//        model.addAttribute("name3", person3.getName());
//        model.addAttribute("age3", person3.getAge());
//
//        model.addAttribute("name4", person4.getName());
//        model.addAttribute("age4", person4.getAge());
//
//        model.addAttribute("name5", person5.getName());
//        model.addAttribute("age5", person5.getAge());
        return "people";

    }

    class Person{
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age= age;
        }

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

    }

}
