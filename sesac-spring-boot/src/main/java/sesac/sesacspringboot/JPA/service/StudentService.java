package sesac.sesacspringboot.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesacspringboot.JPA.dto.StudentDTO;
import sesac.sesacspringboot.JPA.entity.Student;
import sesac.sesacspringboot.JPA.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentDTO> getStudentAll(){
        List<Student> result = studentRepository.findAll();
        List<StudentDTO> students = new ArrayList<>();

        for (Student student : result){
//            각 사용자 정보에 대해 반복적으로 실행될 코드 블록입


//            Builder
//            객체 생성시  1. 생성자 주입  (여러개의 필드가 있을 때 순서를 지켜줘야됨)
//            2. SETTER를 통한 주입(필드 개수만큼 매번 메소드를 만들어야됨)
//            3. Builder : 생성자 주입 대체로.. - 객체를 만들 때 순서에 의해 생기는 문제, 명시적이지 못한 문제를 해결하기 위해 나온 방법
            StudentDTO studentDTO = StudentDTO.builder()
                    .name(student.getName())
                    .nickname(student.getNickname())
                    .build();
            students.add(studentDTO);
//            StudentDTO studentDTO = new StudentDTO();
//            studentDTO.setName("이름")... 과 동일한게 builder
        }
        return students;
    }
}
