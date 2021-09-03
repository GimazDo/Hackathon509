package com.gimaz.hackathon.api;

import com.gimaz.hackathon.entity.User;
import com.gimaz.hackathon.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserAPIController {




    private final UserService userService;



    @PostMapping("/add")
    public @ResponseBody String addUser(@RequestBody User user)
    {

        try {
            userService.register(user);
            return "success";
        }
        catch (Exception e)
        {
            return "failed: " + e.getMessage();
        }
    }

}
