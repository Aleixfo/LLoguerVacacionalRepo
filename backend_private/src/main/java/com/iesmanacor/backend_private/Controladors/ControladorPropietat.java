package com.iesmanacor.backend_private.Controladors;

import com.iesmanacor.backend_private.Models.Entitats.Localitat;
import com.iesmanacor.backend_private.Models.Entitats.Propietat;
import com.iesmanacor.backend_private.Models.Serveis.LocalitatServeiInterface;
import com.iesmanacor.backend_private.Models.Serveis.PropietatServeiInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//NOTACIO OBLIGATORIA (PAQUET AL QUE PERTANY)
@Controller
@RequestMapping("/views/propietats")
public class ControladorPropietat {

    @Autowired
    private PropietatServeiInterface propietatService;

    @Autowired
    private LocalitatServeiInterface localitatService;

    //LListar totes les propietats
    @GetMapping({"/"})
    public String llistarPropietats (Model model){ //Per enviar dades a la vista

        List <Propietat> llistaPropietats = propietatService.listarTodos();

        model.addAttribute("titol", "Llista de propietats");
        model.addAttribute("propietat", llistaPropietats);

        return "/views/propietats/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Propietat p = new Propietat();
        List<Localitat> listLocalitats = localitatService.llistarLocalitats();

        model.addAttribute("titol", "Formulari nova propietat");
        model.addAttribute("propietat", p);
        model.addAttribute("localitats", listLocalitats);



        return "/views/propietats/frmCrearPropietat";
    }

    @PostMapping("/save")
    public String guardar(@Validated @ModelAttribute Propietat p, BindingResult result, Model model){

        List<Localitat> listLocalitats = localitatService.llistarLocalitats();


        if (result.hasErrors()) {

            model.addAttribute("titol", "Formulari nova propietat");
            model.addAttribute("propietat", p);
            model.addAttribute("localitats", listLocalitats);

            System.out.println("ERROR EN EL FORMULARI");

            return "/views/propietats/frmCrearPropietat";
        }

        propietatService.guardar(p);
        System.out.println("Cliente guardado con exito");
        return "redirect:/views/propietats/";
    }


    @GetMapping("/edit/{idPROPIETAT}")
    public String editar(@PathVariable("idPROPIETAT") Long idPROPIETAT, Model model) {

        Propietat p = propietatService.buscarPorId(idPROPIETAT);
        List<Localitat> listLocalitats = localitatService.llistarLocalitats();

        model.addAttribute("titol", "Formulari Editar propietat");
        model.addAttribute("propietat", p);
        model.addAttribute("localitats", listLocalitats);



        return "/views/propietats/frmCrearPropietat";
    }


    @GetMapping("/delete/{idPROPIETAT}")
    public String eliminar(@PathVariable("idPROPIETAT") Long idPROPIETAT) {

        propietatService.eliminar(idPROPIETAT);
        System.out.println("Sha eliminat la propietat amb exit");

        return "redirect:/views/propietats/";
    }



}