package com.weiz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping("/")
    public String index() {
        return "/admin/index";
    }
}
