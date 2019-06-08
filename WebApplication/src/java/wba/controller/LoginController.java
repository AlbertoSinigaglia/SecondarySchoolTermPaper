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
import wba.model.BCrypt;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.model.Ruolo;
import wba.service.ClienteService;
import wba.service.DipendenteService;

/**
 *
 * @author alberto
 */
@Controller
@RequestMapping(value={"/", "login"})
@ComponentScan("wba.service")
@Scope("session")
public class LoginController {
    @Autowired DipendenteService dipendenti;
    @Autowired ClienteService clienti;
    public static final String CLIENTE_HOMEPAGE="cliente/";
    public static final String RESPONSABILE_HOMEPAGE="responsabile/homepage";
    public static final String DIPENDENTE_HOMEPAGE="dipendente/";
    private static final int N_CHIAVE=7;

    @RequestMapping(value = { "/", "login"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "index";
    }
    @RequestMapping(value = "homepage", params = {"username", "password"}, method = RequestMethod.POST)
    public String login(ModelMap map, @RequestParam("username") String nome, @RequestParam("password") String password, HttpSession session) {
        Dipendente dip= dipendenti.findById(nome);
        Cliente cli=clienti.findById(nome);
        if(dip!=null){
            if(checkPassword(password, dip.getPassword())){
                if(!dip.getAccettato())return "richiestaInSospeso";
                session.setAttribute("dipendente", dip);
                if(dip.getRuolo()==Ruolo.AltriRuoli)return "redirect:/"+DIPENDENTE_HOMEPAGE;
                else return "redirect:/"+RESPONSABILE_HOMEPAGE;
            }
            map.addAttribute("errore", "Username e Password non corrispondono");
            return "error";
        }
        else if(cli!=null){
            if(checkPassword(password, cli.getPassword())){
                if(!cli.getAccettato())return "richiestaInSospeso";
                session.setAttribute("cliente", cli);
                return "redirect:/"+CLIENTE_HOMEPAGE;
            }
            map.addAttribute("errore", "Username e Password non corrispondono");
            return "error";
        }
        map.addAttribute("errore", "Non risulti registrato nel sistema, contattare il responsabile");
        return "index";
    }
    @RequestMapping(value = {"richiestaRegistrazione"}, method = RequestMethod.GET)
    public String richiestaRegistrazione(ModelMap model) {
        return "richiestaRegistrazione";
    }
    @RequestMapping(
        value = {"richiediRegDip"}, 
        method = RequestMethod.POST, 
        params = {
            "NOME", "COGNOME","EMAIL","TEL1","PASS1","PASS2"
        }
    )
    public String richiediRegDip(ModelMap model,
            @RequestParam("NOME") String nome, @RequestParam("COGNOME") String cog,
            @RequestParam("EMAIL") String email,
            @RequestParam("TEL1") String tel1, 
            @RequestParam("PASS1") String pass1, @RequestParam("PASS2") String pass2,
            @RequestParam(value = "TEL2", required = false) String tel2)
    {
        if(validateRegDip( nome,  cog,  tel1,  tel2,  email, pass1, pass2)){
            if(tel2==null||tel2.equals(""))tel2=null;
            Dipendente dip=new Dipendente( nome,  cog,  tel1,  tel2,  email, Ruolo.AltriRuoli, hashPassword(pass1));
            dipendenti.saveDipendente(dip);
            return "richiestaInviata";
        }
        return "error";
        
    }
    private boolean validateRegDip(String nome, String cog,String tel1, String tel2, String email, String pass1, String pass2){
        boolean x= 
            !tel1.equals("") &&
            tel1.matches("-?\\d+(\\.\\d+)?") &&
            !nome.equals("") && 
            !cog.equals("") && 
            !email.equals("") && 
            email.contains("@") &&
            !pass1.equals("") &&
            pass1.equals(pass2);
        if(tel2!=null&&!tel2.equals("")){
            x= x&&tel2.matches("-?\\d+(\\.\\d+)?");
        }
        return x && dipendenti.findById(email)==null;
    }
    
    
    @RequestMapping(
        value = {"richiediRegCli"}, 
        method = RequestMethod.POST, 
        params = {
            "DENOM", "PIVA","EMAIL","TEL1","PASS1","PASS2"
        }
    )
    public String richiediRegCli(ModelMap model,
            @RequestParam("DENOM") String denom, @RequestParam("PIVA") String piva,
            @RequestParam("EMAIL") String email,
            @RequestParam("TEL1") String tel1, @RequestParam(value = "TEL2", required = false) String tel2,
            @RequestParam("PASS1") String pass1, @RequestParam("PASS2") String pass2)
    {
        if(validateRegCli( denom,  piva,  tel1,  tel2,  email, pass1, pass2)){
            Cliente cli=new Cliente(piva, email, tel1,  tel2,  denom, hashPassword(pass1));
            clienti.saveCliente(cli);
            return "richiestaInviata";
        }
        return "error";
    }
    private boolean validateRegCli(String denom, String piva,String tel1, String tel2, String email, String pass1, String pass2){
        boolean x= 
            !tel1.equals("") &&
            tel1.matches("-?\\d+(\\.\\d+)?") &&
            !denom.equals("") && 
            !piva.equals("") && 
            piva.matches("-?\\d+(\\.\\d+)?") &&
            piva.length()==11 &&
            !email.equals("") && 
            email.contains("@") &&
            !pass1.equals("") &&
            pass1.equals(pass2);
        if(tel2!=null&&!tel2.equals("")){
            x= x&&tel2.matches("-?\\d+(\\.\\d+)?");
        }
        
        return x && clienti.findById(piva)==null;
    }
    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(N_CHIAVE);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);
        return(hashed_password);
    }
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified;
        if(null == stored_hash || !stored_hash.startsWith("$2a$")) throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
        return(password_verified);
    }
    @RequestMapping(value = {"*"})
    public String error(ModelMap model) {
        return "error404";
    }
   
}