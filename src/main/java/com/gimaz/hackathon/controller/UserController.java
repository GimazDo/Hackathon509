package com.gimaz.hackathon.controller;

import com.gimaz.hackathon.entity.User;
import com.gimaz.hackathon.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/user/add")
    public String getAddUser()
    {
        return "AddUser";
    }

    @PostMapping(value = "user/adduser")
    public String postAddUser(@RequestParam String username,
                              @RequestParam String password)
    {
        User user = new User(username,password,null,null);
        userService.register(user);
        return "AddUser";
    }

}
