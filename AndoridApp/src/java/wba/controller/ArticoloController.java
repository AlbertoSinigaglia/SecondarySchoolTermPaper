/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.controller;

import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wba.model.Articolo;
import wba.service.ArticoloService;
import wba.service.ClienteService;
import wba.utils.GraphObjNc;

/**
 *
 * @author alberto
 */
@Scope("session")
@Controller
@RequestMapping("articolo/")
@ComponentScan("wba.service")
public class ArticoloController {
    @Autowired ArticoloService articoli;
    @ResponseBody
    @RequestMapping(value = "findById", params={"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id") int id){
        return new Gson().toJson(articoli.findById(id));
    }
    @ResponseBody
    @RequestMapping(value = "findAllArticolo", method = RequestMethod.GET)
    public String findAllArticolo(){
        return new Gson().toJson(articoli.findAllArticolo());
    }
    @ResponseBody
    @RequestMapping(value = "getCountArticoli", method = RequestMethod.GET)
    public String getCountArticoli(){
        return ""+articoli.getCountArticoli();
    }
    
}
