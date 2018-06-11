package com.zc.blog.controller;

import com.zc.blog.pojo.User;
import com.zc.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView List(Model model){
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id,Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user",user.get());
        model.addAttribute("title","用户详情");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null,null,null));
        model.addAttribute("title","用户添加");
        return new ModelAndView("users/add","userModel",model);
    }

    @PostMapping()
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.save(user);
        return new ModelAndView("redirect:/users","userModel",user);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id,Model model){
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users","userModel",model);
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id") Long id,Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user",user.get());
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/edit","userModel",model);
    }

}
