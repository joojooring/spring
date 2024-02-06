package sesac.sesacspringboot.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sesac.sesacspringboot.JPA.dto.UserDTO;
import sesac.sesacspringboot.JPA.service.UserTableService;

import java.util.List;
@RestController // @Controller + @ResponseBody
@RequestMapping("/useruser")
public class UserTableController {
    @Autowired
    UserTableService userTableService;

    @GetMapping("/all") // /user/all
    public List<UserDTO> getAll(){
        List<UserDTO> result = userTableService.getUserAll();
        return result;
    }
}
