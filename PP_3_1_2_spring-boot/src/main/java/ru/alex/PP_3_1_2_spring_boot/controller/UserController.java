package ru.alex.PP_3_1_2_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alex.PP_3_1_2_spring_boot.model.User;
import ru.alex.PP_3_1_2_spring_boot.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @PostMapping("users/delete")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "users/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "user-create";
    }

    @PostMapping("users/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit-user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }
}
