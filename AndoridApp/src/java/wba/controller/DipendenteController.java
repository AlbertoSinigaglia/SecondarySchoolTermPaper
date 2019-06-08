/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.controller;

import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wba.model.Dipendente;
import wba.model.NonConformita;
import wba.model.Ruolo;
import wba.utils.NonConformitaUtils;
import wba.service.NonConformitaService;
import wba.service.ArticoloService;
import wba.service.DipendenteService;
import wba.service.PezzoService;

/**
 *
 * @author alberto
 */
@Controller
@RequestMapping("dipendente/")
@ComponentScan("wba.service")
@Scope("session")
public class DipendenteController {
    @Autowired DipendenteService dipendenti;
    @ResponseBody
    @RequestMapping(value = "findById", params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id")String id){
        return new Gson().toJson(dipendenti.findById(id));
    }
    @ResponseBody
    @RequestMapping(value = "findAllDipendente", method = RequestMethod.GET)
    public String findAllDipendente(){
        return new Gson().toJson(dipendenti.findAllDipendente());
    }
    @ResponseBody
    @RequestMapping(value = "findOnlyDipendenti", method = RequestMethod.GET)
    public String findOnlyDipendenti(){
        return new Gson().toJson(dipendenti.findOnlyDipendenti());
    }
    @ResponseBody
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public String findRichieste(){
        return new Gson().toJson(dipendenti.findRichieste());
    }
}
