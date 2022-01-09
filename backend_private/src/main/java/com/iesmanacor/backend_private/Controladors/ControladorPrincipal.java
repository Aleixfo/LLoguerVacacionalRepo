package com.iesmanacor.backend_private.Controladors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPrincipal {


    @GetMapping ({"/", "/index"})
    public String index(Model model) {

        return "index";
    }




}
