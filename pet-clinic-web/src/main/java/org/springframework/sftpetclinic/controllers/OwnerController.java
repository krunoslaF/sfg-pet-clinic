package org.springframework.sftpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/owners"})
public class OwnerController {

    public static final String OWNER_VIEW = "owners/owners";

    @GetMapping({"/owners", "/", ""})
    public String listOwners(){
        return OWNER_VIEW;
    }
}
