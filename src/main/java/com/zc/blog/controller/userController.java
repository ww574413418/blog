package com.zc.blog.controller;

import com.zc.blog.pojo.User;
import com.zc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("users")
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView sayHello(Model model){
        model.addAttribute("user",userService.listUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","用户管理");
        return new ModelAndView("","userModel",model);
    }

    @GetMapping("form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",userService.SaveOrUpdateUser(new User()));
        model.addAttribute("title","用户管理");
        return new ModelAndView("user/form","userModel",model);
    }

    @PostMapping("")
    public ModelAndView saveOrUpdateUser(User user){
        user = userService.SaveOrUpdateUser(user);
        return new ModelAndView("user/form","userModel",user);
    }
}
