package com.web.controller;

import com.web.Service.UserServiceImp;
import com.web.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/")
public class UserController {
    private final UserServiceImp userService;

    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/users")
    public String show(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "show";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/users/{id}")
    public String update(
            @ModelAttribute("user") @Valid User user,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            return "edit";
        userService.update(user.getId(), user);
        return "redirect:/";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(@ModelAttribute("user") User user) {
        return "edit";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam(value = "id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/users/add_default_users")
    public String addDefaultUsers() {
        userService.addDefaultUsers();
        return "redirect:/";
    }

}
