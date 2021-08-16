package com.weiz.controller;

import com.weiz.pojo.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot Web!";
    }

    @RequestMapping("/save")
    public String save(@Validated Student student, BindingResult result){
        return student.getFirstName() +" "+ student.getLastName();
    }

    @RequestMapping("/save")
    public String save(Student student){
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        return firstName +" "+ lastName;
    }

    @RequestMapping("/check")
    public String check(@Valid Student student){
        return "检测完毕！没有问题";
    }

    @PostMapping(path = "/save2")
    public String save2(@RequestBody Student student) {
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        return firstName +" "+ lastName;
    }
}
