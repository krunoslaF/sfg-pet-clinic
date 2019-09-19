package org.springframework.sftpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    public static final String INDEX_VIEW = "index";

    @GetMapping({"/", "", "/index", "/index.html"})
    public String index(){
        return INDEX_VIEW;
    }
}
