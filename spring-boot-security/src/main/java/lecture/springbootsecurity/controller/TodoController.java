package lecture.springbootsecurity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @GetMapping("")

    public String getTodo(@AuthenticationPrincipal String userId){
//        @AuthenticationPrincipal : SecurityContextHolder에서 user정보에 대한걸 받아올 수 있음
//        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        : 값을 자동으로 userId에 할당해주는 역할
        return "Get /todo by userID" + userId;
    }
}
