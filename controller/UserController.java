package project.planner.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/members")
    public String log() {
        return "members/login";
    }

    @PostMapping("/logIn")
    public String login(HttpSession session, UserForm userForm) {

        // 로그인 성공 후 세션에 user_index 설정
        session.setAttribute("user_index", userForm.getIndex());
        return "redirect:/";
    }
}
