package sesac.sesacspringboot.controllerMyBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sesac.sesacspringboot.dto.UserDTO;
import sesac.sesacspringboot.service.UserService;

import java.util.List;

@RequestMapping("/user")
//@RequestMapping 동일한 url을 한번에 정의해줌
@RestController

//responsebody + controller
//: 응답한 결과자체를 불러오는게 responsebody
public class UserControllerMyBatis {
//    create, read
//    1.Table 생성 완료(user)
//    2.domain 만들기(domain/user)
//    3.mapper 만들기
//    4. service 만들기
//    5. controller 만들기


    @Autowired
    UserService userService;

    @GetMapping("/all") //실제경로는 /user/all ->위에 RequestMapping 어노테이션으로 동일한 url정의해줬으니까
    public List<UserDTO> getUser(){
        List<UserDTO> result = userService.retrieveAll();
        return result;
    } //[]


    @GetMapping("/user") // /user/user
    public String getUserInsert(@RequestParam String name,
                              @RequestParam String nickname){
        userService.createUser(name, nickname);
        return "Success";
    } //"Success"

//    update실습
    @GetMapping("/useruser")
    public String getUserUpdate(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String nickname
                                ){
        userService.updateUser(id,name,nickname);
        return "Update";
    }

//    delete실습
    @GetMapping("/userdelete")
    public String getUserDelete(
                                @RequestParam int id
                                ){
        userService.deleteUser(id);
        return "Delete";
    }



}
