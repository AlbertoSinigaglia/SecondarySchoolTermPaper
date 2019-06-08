/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.model.NonConformita;
import wba.service.ArticoloService;
import wba.service.ClienteService;
import wba.service.NonConformitaService;
import wba.service.PezzoService;

/**
 *
 * @author alberto
 */
@Scope("session")
@Controller
@RequestMapping("cliente/")
@ComponentScan("wba.service")
public class ClienteController {
    Cliente cliente;
    @Autowired NonConformitaService nc;
    @Autowired ArticoloService articoli;
    @Autowired PezzoService pezzi;
    private static final String ERROR_PAGE="error";
    private static final String FOLDER="cliente/";
    
    @RequestMapping(value = { "/", "homepage"})
    public String homepage(ModelMap model, HttpSession session) {
        cliente=(Cliente)session.getAttribute("cliente");
        if (checkAccess()) return ERROR_PAGE;
        model.addAttribute("articoli", articoli.findAllArticolo());
        model.addAttribute("reclamiG", nc.findAllReclamiGest(cliente));
        model.addAttribute("reclamiNG", nc.findAllReclamiNonGest(cliente));
        return FOLDER+"index";
    }
    @RequestMapping(value = "nuovoReclamo", params = {"problematica", "s1","s2"}, method = RequestMethod.POST)
    public String nuovaSegnalazione(ModelMap model, 
            @RequestParam("problematica") String prob,
            @RequestParam("s1")int s1, 
            @RequestParam("s2")int s2) {
        if(checkAccess())return ERROR_PAGE;
        NonConformita newNC=new NonConformita();
        newNC.setDescrProblema(prob);
        newNC.setArticolo(articoli.findById(s1));
        newNC.setPezzo(pezzi.findById(s2));
        newNC.setCliente(cliente);
        newNC.setDipendenteRisc(null);
        nc.saveNonConformita(newNC);
        return "redirect:./";
    }
    @RequestMapping(value = { "logout"})
    public String logout(ModelMap model, HttpSession session) {
        session.removeAttribute("cliente");
        return "redirect:../";
    }
    private boolean checkAccess(){
        return cliente==null;
    }
    @RequestMapping(value = {"*"})
    public String error(ModelMap model) {
        return "error404";
    }
}
