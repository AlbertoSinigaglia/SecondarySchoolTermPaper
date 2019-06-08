/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.controller;

/**
 *
 * @author albertosinigaglia
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import wba.model.Articolo;
import wba.model.BCrypt;
import wba.model.Cliente;
import wba.model.DipNc;
import wba.model.Dipendente;
import wba.model.NonConformita;
import wba.model.Pezzo;
import wba.model.Ruolo;
import wba.service.ArticoloService;
import wba.service.ClienteService;
import wba.service.DipNCService;
import wba.service.DipendenteService;
import wba.service.NonConformitaService;
import wba.service.PezzoService;

/**
 *
 * @author alberto
 */
@Controller
@RequestMapping(value={"nc/"})
@ComponentScan("wba.service")
@Scope("session")
public class NonConformitaController {
    @Autowired DipendenteService dipendenti;
    @Autowired ClienteService clienti;
    @Autowired NonConformitaService nc;
    @Autowired PezzoService pz;
    @Autowired ArticoloService art;
    @Autowired DipNCService dnc;
    @ResponseBody
    @RequestMapping(value = "findById", params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id")Integer id){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.findById(id));
    }
    @ResponseBody
    @RequestMapping(value = "findAllNC", method = RequestMethod.GET)
    public String findAllNC(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.findAllNonConformita());
    }
    @ResponseBody
    @RequestMapping(value = "findAllOpenNC", method = RequestMethod.GET)
    public String findAllOpenNC(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.findAllOpenNC());
    }
    @ResponseBody
    @RequestMapping(value = "findAllCloseNC", method = RequestMethod.GET)
    public String findAllCloseNC(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.findAllCloseNC());
    }
    @ResponseBody
    @RequestMapping(value = "findAllSegn", method = RequestMethod.GET)
    public String findAllSegn(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.findAllSegn());
    }
    @ResponseBody
    @RequestMapping(value = "findAllInEsecNC", method = RequestMethod.GET)
    public String findAllInEsecNC(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.findAllInEsecNC());
    }
    @ResponseBody
    @RequestMapping(value = "getLastLC", method = RequestMethod.GET)
    public String getLastLC(){
        try{
        Date date = nc.getLastLC();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.YEAR);
        }catch(Exception e){return null;}
    }
    @ResponseBody
    @RequestMapping(value = "getLastLA", method = RequestMethod.GET)
    public String getLastLA(){
        try{
        Date date = nc.getLastLA();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.YEAR);
        }catch(Exception e){return null;}
    }
    @ResponseBody
    @RequestMapping(value = "getLastLE", method = RequestMethod.GET)
    public String getLastLE(){
        try{
        Date date = nc.getLastLE();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.YEAR);
        }catch(Exception e){return null;}
    }
    @ResponseBody
    @RequestMapping(value = "findAllReclami", method = RequestMethod.GET)
    public String findAllReclami(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.findAllReclami());
    }
    @ResponseBody
    @RequestMapping(value = "getCountAperte", method = RequestMethod.GET)
    public String getCountAperte(){
        return ""+nc.getCountAperte();
    }
    @ResponseBody
    @RequestMapping(value = "getCountChiuse", method = RequestMethod.GET)
    public String getCountChiuse(){
        return ""+nc.getCountChiuse();
    }
    @ResponseBody
    @RequestMapping(value = "getCountEsec", method = RequestMethod.GET)
    public String getCountEsec(){
        return ""+nc.getCountEsec();
    }
    @ResponseBody
    @RequestMapping(value = "getOnlyNC", method = RequestMethod.GET)
    public String getOnlyNC(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(nc.getOnlyNc());
    }
    @ResponseBody
    @RequestMapping(value = "getPezziNC", params = {"cat"}, method = RequestMethod.GET)
    public String getPezziNC(@RequestParam("cat")String cat){
        List<NonConformita>tmp= new ArrayList<>();
        switch(cat){
            case "aperte":
                tmp=nc.findAllOpenNC();
                break;
            case "esec":
                tmp=nc.findAllInEsecNC();
                break;
            case "chiuse":
                tmp=nc.findAllCloseNC();
                break;
        }
        List<Pezzo> pezzi=new ArrayList<>();
        for(NonConformita idp: tmp){
            pezzi.add(pz.findById(idp.getPezzo()));
        }
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(pezzi);
    }
    @ResponseBody
    @RequestMapping(value = "getArticoliNC", params = {"cat"}, method = RequestMethod.GET)
    public String getArticoliNC(@RequestParam("cat")String cat){
        List<NonConformita>tmp= new ArrayList<>();
        switch(cat){
            case "aperte":
                tmp=nc.findAllOpenNC();
                break;
            case "esec":
                tmp=nc.findAllInEsecNC();
                break;
            case "chiuse":
                tmp=nc.findAllCloseNC();
                break;
        }
        List<Articolo> articoli=new ArrayList<>();
        for(NonConformita idp: tmp){
            articoli.add(art.findById(idp.getArticolo()));
        }
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(articoli);
    }
    @ResponseBody
    @RequestMapping(value = "getArticoliReclami", method = RequestMethod.GET)
    public String getArticoliReclami(){
        List<NonConformita>tmp= new ArrayList<>();
        tmp=nc.findAllReclami();
        List<Articolo> articoli=new ArrayList<>();
        for(NonConformita idp: tmp){
            articoli.add(art.findById(idp.getArticolo()));
        }
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(articoli);
    }
    @ResponseBody
    @RequestMapping(value = "getPezziReclami", method = RequestMethod.GET)
    public String getPezziReclami(){
        List<NonConformita>tmp= new ArrayList<>();
        tmp=nc.findAllReclami();
        List<Pezzo> pezzi=new ArrayList<>();
        for(NonConformita idp: tmp){
            pezzi.add(pz.findById(idp.getPezzo()));
        }
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(pezzi);
    }
    @ResponseBody
    @RequestMapping(value = "getArticoliSegnalazioni", method = RequestMethod.GET)
    public String getArticoliSegnalazioni(){
        List<NonConformita>tmp= new ArrayList<>();
        tmp=nc.findAllSegn();
        List<Articolo> articoli=new ArrayList<>();
        for(NonConformita idp: tmp){
            articoli.add(art.findById(idp.getArticolo()));
        }
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(articoli);
    }
    @ResponseBody
    @RequestMapping(value = "getPezziSegnalazioni", method = RequestMethod.GET)
    public String getPezziSegnalazioni(){
        List<NonConformita>tmp= new ArrayList<>();
        tmp=nc.findAllSegn();
        List<Pezzo> pezzi=new ArrayList<>();
        for(NonConformita idp: tmp){
            pezzi.add(pz.findById(idp.getPezzo()));
        }
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(pezzi);
    }
    @ResponseBody
    @RequestMapping(value = "getTeam", params={"id"}, method = RequestMethod.GET)
    public String getTeam(@RequestParam("id") Integer id){
        List<DipNc>tmp= new ArrayList<>();
        tmp=dnc.findByNC(id);
        List<Dipendente> dip=new ArrayList<>();
        for(DipNc idp: tmp){
            dip.add(dipendenti.findById(idp.getEmail()));
        }
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().toJson(dip);
    }
}