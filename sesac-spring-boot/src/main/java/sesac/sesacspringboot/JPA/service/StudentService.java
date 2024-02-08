package sesac.sesacspringboot.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesacspringboot.JPA.dto.StudentDTO;
import sesac.sesacspringboot.JPA.entity.Student;
import sesac.sesacspringboot.JPA.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public String insertStudent(String name, String nickname, Student.LoginType type){
//        받아온 데이터로 repository의 save 메소드 출력 (save메소드는 insert into 기능)
//        저장할 Student 엔티티를 객체로 만들어 줘야 됨 이때 builder 사용
        Student student = Student.builder().name(name).nickname(nickname).type(type).build();
        Student newStudent = studentRepository.save(student);
//        newStudent는 save를 한 후 반환되는 Entity 객체 (insert into 하고 select했다고 생각하면 됨)
        return newStudent.getId() + newStudent.getName();

    }
//    =================================실습==================================
    //    =================================실습==================================

    public String countStudent(String nickname){
//        Student student = Student.builder().nickname(nickname).build();
//        Student newStudent = studentRepository.count();
//
//        return newStudent.getNickname();
        long studentCount = studentRepository.countByNickname(nickname);
        return "일치하는 친구 수: " + studentCount;
    }


    public String updatePracStudent(int id, String name){

        Student student = Student.builder().name(name).build();
        Student newStudent = studentRepository.save(student);

        return newStudent.getName();

    }

    //    ===================================================================
    //    ===================================================================
    public String searchStudentByName(String name){
         List<Student> student = studentRepository.findByName(name);
        return "id는 " + student.size()+"명 입니다.";
//        Student student = studentRepository.findByName(name);
//        return "id는 " + student.getId()+" 입니다.";
    }


    public String searchStudentById(int id){
//        Student student = studentRepository.findById(id);
//        return student.getName();



//        id는 findByid 옵셔널로 받으면 되고
//        List는 절대 null 아니 아니니까 옵셔널 쓸 필요가 없음


        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
//            isPresent() : 객체의 여부를 boolean으로 반환
            Student student1 = student.get();

            return  student.get().getName();
//            get() : Optional에 담긴 객체를 반환 해주는 메소드
        }
        return "null";

//        Optional<Student> student = studentRepository.findById(id);
//        if(student.isPresent()){
////            isPresent() : 객체의 여부를 boolean으로 반환
//            return  student.get().getName();
////            get() : Optional에 담긴 객체를 반환 해주는 메소드
//        }
//        return "null";
//        Optional이 생겨나면서 Student 객체 자체로 받는게 안되게 됨
//        Optional<T> : Java 8부터 등장한 친구
//        null일 수도 있는 개체를 감싸는 wrapper 클래스

    }



    public int searchCntByNickname(String nickname){
//        count 라는 method를 활용해라.
//        countByNickname(String nickname) =
        return  studentRepository.countByNickname(nickname);
    }

    public String updateStudent(int id, String name){

//        update시 save 사용
//        save(T) : 새로운 entity를 삽입 하거나 기존 entity를 update
//        T의 기본값 (PK) 의 상태에 따라 다르게 동작
//        -PK 값이 존재하는 경우 : PK와 연결된 entity를 update
//        -PK 값이 없는 경우 : 새로운 ENTITY INSERT
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("ID IS WRONG"));

        Student modifiedStudent = Student.builder()
                .id(id)
                .name(name)
                .nickname(student.getNickname())
                .type(student.getType())
                .build();
//        save를 동작시카ㅣ기 위해 엔티티가 필요해서 위에꺼를 만들어준거임

        studentRepository.save(modifiedStudent);
        return "Update success";
    }
}
