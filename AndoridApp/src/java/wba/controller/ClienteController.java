/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wba.service.ClienteService;

/**
 *
 * @author alberto
 */
@Scope("session")
@Controller
@RequestMapping("cliente/")
@ComponentScan("wba.service")
public class ClienteController {
    @Autowired ClienteService clienti;
    @ResponseBody
    @RequestMapping(value = "findById", params={"piva"}, method = RequestMethod.GET)
    public String findById(@RequestParam("piva") String piva){
        return new Gson().toJson(clienti.findById(piva));
    }
    @ResponseBody
    @RequestMapping(value = "findAllCliente", method = RequestMethod.GET)
    public String findAllCliente(){
        return new Gson().toJson(clienti.findAllCliente());
    } 
    @ResponseBody
    @RequestMapping(value = "findRichieste", method = RequestMethod.GET)
    public String findRichieste(){
        return new Gson().toJson(clienti.findRichieste());
    }
    @ResponseBody
    @RequestMapping(value = "findOnlyClienti", method = RequestMethod.GET)
    public String findOnlyClienti(){
        return new Gson().toJson(clienti.findOnlyClienti());
    }
}
