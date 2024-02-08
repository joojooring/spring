package sesac.sesacspringboot.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sesac.sesacspringboot.JPA.dto.StudentDTO;
import sesac.sesacspringboot.JPA.entity.Student;
import sesac.sesacspringboot.JPA.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
//    @GetMapping("/count")
//    public int getCountAll(){
//
//    }
    @Autowired
    StudentService studentService;


//    @GetMapping("/all")
////    public int getAll(){
//    public List<StudentDTO> getALL(){
////        student의 목록을 전부 가져와서 보여주는 api
//        return studentService.getStudentAll();
//    }


//    1. 전체 검색 (select * from student) - finaAll 사용
//    2. 삽입 ( insert into ~~) - save 사용
//    3. 조건에 따른 검색 ( select * from student name = '')
//    3-1. 조건에 따른 검색 (select * from student where id = )


    //    1. 전체 검색 (select * from student)
    @GetMapping("/all")
    public  List<StudentDTO> getAll(){
        // student의 목록을 전부 가져와서 보여주는 api
        List<StudentDTO> result = studentService.getStudentAll();
        return result;
//        return result.size();
//        return studentService.getStudentAll();
    }


//    @GetMapping("/search")
//    public ? getSearch(@RequestBody int id){
//
//    }

    //    2. 삽입 ( insert into ~~) - save 사용
    @GetMapping("/insert")//?로 보내기 위해  /student/insert?name=이름
//    http://localhost:8080/student/insert?name=%EC%9D%B4%EB%A6%84&nickname=%EB%8B%88%EA%B2%8C%EC%9E%84&type=GOOGLE

    public String insertStudent(@RequestParam String name,
                                @RequestParam String nickname,
                                @RequestParam Student.LoginType type) {//?로 보내기 위해

        return studentService.insertStudent(name,nickname,type);
//        return name + type;
    }

//    3. 조건에 따른 검색 ( select * from student name = '')
    @GetMapping("/search/name") // search/name?name=이름
    public String searchStudentByName(@RequestParam String name){
        return studentService.searchStudentByName(name);
    }

//    3-1. 조건에 따른 검색 (select * from student where id = )
    @GetMapping("/search/id")
    public String searchStudentById(@RequestParam int id){
        return studentService.searchStudentById(id);
    }




//    ======================실습============
//    ======================실습============
    @GetMapping("/search/nickname")
    public String searchPracStudent(@RequestParam String nickname){
        return studentService.countStudent(nickname);
    }


    @GetMapping("/update/name")
    public String updatePracStudent(@RequestParam int id, String name){
        return studentService.updatePracStudent(id, name);
    }




// 실습정답
    @GetMapping("/count")
    public int searchCntByNickname(@RequestParam String nickname){
    return studentService.searchCntByNickname(nickname);
    }

    @GetMapping("/updateupdate")
    public String updateStudent (@RequestParam int id,
                                 @RequestParam String name){
//        id : 내가 변경할 데이터의 primary key
//        name : 내가 변경하고자 하는 name 컬럼의 ㄱ밧
        return studentService.updateStudent(id,name);

    }

    }


