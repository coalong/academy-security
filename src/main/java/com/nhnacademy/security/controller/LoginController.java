package com.nhnacademy.security.controller;

import com.nhnacademy.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req) {
        HttpSession session = req.getSession(false);

        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
            return "login";
        }

        return "loginSuccess";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest req) {
        if (userService.matches(id, pwd)) {
            HttpSession session = req.getSession(true); // 세션생성
            session.setAttribute("id", id);

            return "loginSuccess";
        }
        return "redirect:/login";
    }

}
