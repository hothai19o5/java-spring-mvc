package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @RequestMapping("/")
    public String getHomePage() {
        return "hello";
    }
}

// @RestController
// public class UserController {
// // Dependency injection
// // Khong nen dung @Autowired
// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping(" ")
// public String getHomePage() {
// return this.userService.handleHello();
// }
// }
