package wba.controller;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import static wba.controller.LoginController.CLIENTE_HOMEPAGE;
import static wba.controller.LoginController.DIPENDENTE_HOMEPAGE;
import static wba.controller.LoginController.RESPONSABILE_HOMEPAGE;
import static wba.controller.LoginController.checkPassword;
import wba.model.Articolo;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.model.Pezzo;
import wba.model.Ruolo;
import wba.service.ArticoloService;
import wba.service.ClienteService;
import wba.service.DipendenteService;
import wba.service.PezzoService;
import wba.utils.JSONPair;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
@Controller
@RequestMapping("ajax/")
@ComponentScan("wba.service")
@Scope("session")
public class AjaxController {
    @Autowired ArticoloService articoli;
    @Autowired PezzoService pezzi;
    @Autowired DipendenteService d;
    @Autowired ClienteService c;
    //CONTROLLER PER SEGNALAZIONE E RECLAMI
    @RequestMapping(value = "pezzi", params = {"articolo"}, method = RequestMethod.GET)
    @ResponseBody
    public String pezzi(ModelMap model, @RequestParam("articolo") int articolo) {
        if (checkAccess()) return "errore";
        JSONPair lista=new JSONPair();
        Set<Pezzo> set= articoli.findById(articolo).getPezzi();
        for(Pezzo pezzo: set){
            lista.add(pezzo.getCodicePezzo(), pezzo.getNome());
        }
        return new Gson().toJson(lista);
    }
    
    //CONTROLLER PER PEZZI
    @RequestMapping(value = "hasArticoli", params = {"idpezzo"}, method = RequestMethod.GET)
    @ResponseBody
    public String hasArticoli(ModelMap model, @RequestParam("idpezzo") int id) {
        if (checkAccess()) return "-1";
        Pezzo pezzo= pezzi.findById(id);
        if(pezzo.getArticoli().isEmpty()) return "2";
        if(pezzo.getNonConf().isEmpty()&&pezzo.getArticoli().isEmpty()) return "1";
        return "0";
    }
    @RequestMapping(value = "eliminaPezzo", params = {"idpezzo"}, method = RequestMethod.GET)
    public void eliminaPezzo(ModelMap model, @RequestParam("idpezzo") int id) {
        if (checkAccess()) return;
        pezzi.deletePezzo(id);
    }
    
    //CONTROLLER PER ARTICOLI
    @RequestMapping(value = "hasNC", params = {"idarticolo"}, method = RequestMethod.GET)
    @ResponseBody
    public String hasNC(ModelMap model, @RequestParam("idarticolo") int id) {
        if (checkAccess()) return "-1";
        Articolo art= articoli.findById(id);
        if(art.getNonConf().isEmpty()) return "0";
        return "1";
    }
    @RequestMapping(value = "eliminaArticolo", params = {"idarticolo"}, method = RequestMethod.GET)
    public void eliminaArticolo(ModelMap model, @RequestParam("idarticolo") int id) {
        if (checkAccess()) return;
        
        articoli.deleteArticolo(id);
    }
    //controllo accesso
    private boolean checkAccess(){
        return false;
    }
    @ResponseBody
    @RequestMapping(value = "exist", params = {"username", "password"}, method = RequestMethod.GET)
    public String exist(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password) {
        Dipendente dip= d.findById(username);
        Cliente cli=c.findById(username);
        if(dip!=null){
            if(checkPassword(password, dip.getPassword())){
                return "0";
            }
        }
        else if(cli!=null){
            if(checkPassword(password, cli.getPassword())){
                return "0";
            }
        }
        return "1";
    }
    
}
