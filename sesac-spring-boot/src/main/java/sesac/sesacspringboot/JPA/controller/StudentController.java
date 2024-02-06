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
}
