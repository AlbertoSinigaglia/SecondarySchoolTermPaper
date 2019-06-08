/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import wba.model.BCrypt;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.model.Ruolo;
import wba.service.ClienteService;
import wba.service.DipendenteService;
import wba.service.NonConformitaService;

/**
 *
 * @author alberto
 */
@Controller
@RequestMapping(value={"/", "login/"})
@ComponentScan("wba.service")
@Scope("session")
public class LoginController {
    @Autowired DipendenteService dipendenti;
    @Autowired ClienteService clienti;
    @Autowired NonConformitaService nc;
    @RequestMapping(value = "login", params = {"username", "password"}, method = RequestMethod.GET)@ResponseBody
    public String login(ModelMap map, @RequestParam("username") String nome, @RequestParam("password") String password, HttpSession session) {
        Dipendente dip= dipendenti.findById(nome);
        if(dip!=null){
            if(checkPassword(password, dip.getPassword())){
                if(dip.getRuolo()==Ruolo.AltriRuoli) return null;
                session.setAttribute("dipendente", dip);
                return "ok";
            }
            else return null;
        }
        return null;
    }
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified;
        if(null == stored_hash || !stored_hash.startsWith("$2a$")) throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
        return(password_verified);
    }
}