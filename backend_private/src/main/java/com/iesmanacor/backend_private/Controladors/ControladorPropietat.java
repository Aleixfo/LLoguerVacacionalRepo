package com.iesmanacor.backend_private.Controladors;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.iesmanacor.backend_private.Models.Entitats.Municipi;
import com.iesmanacor.backend_private.Models.Entitats.Propietat;
import com.iesmanacor.backend_private.Models.Serveis.MunicipiServeiInterface;
import com.iesmanacor.backend_private.Models.Serveis.PropietatServei;
import com.iesmanacor.backend_private.Models.Serveis.PropietatServeiInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    private MunicipiServeiInterface municipiService;

    //LListar totes les propietats
    @GetMapping({"/"})
    public String llistarPropietats (Model model){ //Per enviar dades a la vista

        List <Propietat> llistaPropietats = propietatService.listarTodos();

        model.addAttribute("titol", "Llista de propietats");
        model.addAttribute("propietat", llistaPropietats);

        return "/views/propietats/listar"; //El return ha de retornar el nom de la vista (index.html)
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Propietat p = new Propietat();
        List<Municipi> listMunicipis = municipiService.llistarMunicipis();

        model.addAttribute("titol", "Formulari nova propietat");
        model.addAttribute("propietat", p);
        model.addAttribute("municipis", listMunicipis);



        return "/views/propietats/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Validated @ModelAttribute Propietat p, BindingResult result, Model model){

        List<Municipi> listMunicipis = municipiService.llistarMunicipis();


        if (result.hasErrors()) {

            model.addAttribute("titol", "Formulari nova propietat");
            model.addAttribute("propietat", p);
            model.addAttribute("municipis", listMunicipis);

            System.out.println("ERROR EN EL FORMULARI");

            return "/views/propietats/frmCrear";
        }

        propietatService.guardar(p);
        System.out.println("Cliente guardado con exito");
        return "redirect:/views/propietats/";
    }

    @GetMapping("/edit/{idPropietat}")
    public String editar(@PathVariable("idPropietat") Long idPROPIETAT, Model model) {

        Propietat p = propietatService.buscarPorId(idPROPIETAT);
        List<Municipi> listMunicipis = municipiService.llistarMunicipis();

        model.addAttribute("titol", "Formulari Editar propietat");
        model.addAttribute("propietat", p);
        model.addAttribute("municipis", listMunicipis);



        return "/views/propietats/frmCrear";
    }


    @GetMapping("/delete/{idPropietat}")
    public String eliminar(@PathVariable("idPropietat") Long idPROPIETAT) {

        propietatService.eliminar(idPROPIETAT);
        System.out.println("Sha eliminat la propietat amb exit");

        return "redirect:/views/propietats/";
    }



}