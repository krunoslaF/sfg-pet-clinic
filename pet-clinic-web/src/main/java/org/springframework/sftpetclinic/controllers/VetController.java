package org.springframework.sftpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class VetController {

    public static final String VET_VIEW = "vets/vets";

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"/vet", "/vets", "vetlist", "vetslist"})
    public String listVets(Model model) {
        model.addAttribute("vetList", vetService.findAll());
        return VET_VIEW;
    }
}
