package com.nhnacademy.security.controller;

import com.nhnacademy.security.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {
    private final LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;}


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public

}

//    @GetMapping(value = {"/", "/login"})
//    public String login(@ModelAttribute("user")  String userId) {
//        if (Objects.isNull(userId)) {
//            // 로그인 안되있으면 loginForm
//            return "index/loginForm";
//        } else {
//            return "index/home";
//        }
//    }
//
//
//    @PostMapping("/login")
//    public String doLogin(@RequestParam("id") String id,
//                          @RequestParam("pwd") String pwd,
//                          HttpServletRequest request,
//                          ModelMap modelMap) {
//        if (userService.matches(id, pwd)) {
//            //성공시
//            HttpSession session = request.getSession();
//            session.setAttribute("id", id);
//
//            modelMap.put("id", session.getAttribute("id"));
//            return "index/loginSuccess";
//        } else {
//            //실패시
//            return "redirect:/login";
//        }
//    }