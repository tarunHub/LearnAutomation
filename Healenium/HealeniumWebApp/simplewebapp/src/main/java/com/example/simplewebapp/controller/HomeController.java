//package com.example.simplewebapp.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class HomeController {
//
//    @GetMapping("/")
//    public String showForm() {
//        return "form";
//    }
//
//    @PostMapping("/submit")
//    public String handleSubmit(@RequestParam String username,
//                               @RequestParam String password,
//                               Model model) {
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
//        return "thanks";
//    }
//
//
////    @GetMapping("/login")
////    public String loginPage() {
////        return "login"; // login.html
////    }
//
//}
