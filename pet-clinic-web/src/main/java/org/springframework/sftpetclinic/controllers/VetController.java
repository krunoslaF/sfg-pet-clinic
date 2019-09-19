package org.springframework.sftpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    public static final String VET_VIEW = "vets/vets";

    @GetMapping({"/vet", "/vets", "vetlist", "vetslist"})
    public String listVets(){
        return VET_VIEW;
    }
}
