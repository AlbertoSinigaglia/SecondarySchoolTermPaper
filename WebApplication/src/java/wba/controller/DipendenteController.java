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
    Dipendente dipendente;
    private static final String ERROR_PAGE="error";
    private static final String FOLDER="dipendente/";
    @Autowired
    NonConformitaService nc;
    @Autowired
    ArticoloService articoli;
    @Autowired
    PezzoService pezzi;
    @Autowired DipendenteService dipendenti;
    public DipendenteController(){
        
    }
    @RequestMapping(value = { "/", "homepage"})
    public String homepage(ModelMap model, HttpSession session) {
        dipendente=(Dipendente)session.getAttribute("dipendente");
        if (checkAccess()) return ERROR_PAGE;
        model.addAttribute("nomeDip", dipendente.getNome()+" "+dipendente.getCognome());
        model.addAttribute("nAperte", NonConformitaUtils.getNumNcAperte(dipendente.getNonConfGest()));
        model.addAttribute("nEsec", NonConformitaUtils.getNumNcEsec(dipendente.getNonConfGest()));
        model.addAttribute("nChiuse", NonConformitaUtils.getNumNcChiuse(dipendente.getNonConfGest()));
        model.addAttribute("dataLA", NonConformitaUtils.getLA(dipendente.getNonConfGest()));
        model.addAttribute("dataLE", NonConformitaUtils.getLE(dipendente.getNonConfGest()));
        model.addAttribute("dataLC", NonConformitaUtils.getLC(dipendente.getNonConfGest()));
        return FOLDER+"index";
    }
    @RequestMapping(value = "aperte", method = RequestMethod.GET)
    public String aperte(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("nc", NonConformitaUtils.getNCAperte(dipendente.getNonConfGest()));
        return FOLDER+"nonConformita";
    }
    @RequestMapping(value = "chiuse", method = RequestMethod.GET)
    public String chiuse(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("nc", NonConformitaUtils.getNCChiuse(dipendente.getNonConfGest()));
        return FOLDER+"nonConformita";
    }
    @RequestMapping(value = "esec", method = RequestMethod.GET)
    public String esec(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("nc", NonConformitaUtils.getNCEsec(dipendente.getNonConfGest()));
        return FOLDER+"nonConformita";
    }
    @RequestMapping(value = "creaSegnalazione", method = RequestMethod.GET)
    public String creaSegnalazione(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("articoli", articoli.findAllArticolo());
        map.addAttribute("segnalazioni", nc.findAllSegnByDip(dipendente));
        return FOLDER+"creaSegnalazione";
    }
    @RequestMapping(value = "infoNC", params = {"nr"}, method = RequestMethod.GET)
    public String infoNC(ModelMap model, @RequestParam("nr") int nr) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("nc", nc.findById(nr));
        return FOLDER+"infoNC";
    }
    private boolean checkAccess(){
        return dipendente==null||dipendente.getRuolo()!=Ruolo.AltriRuoli;
    }
    @RequestMapping(value = "nuovaSegnalazione", params = {"problematica", "s1","s2"}, method = RequestMethod.POST)
    public String nuovaSegnalazione(ModelMap model, 
            @RequestParam("problematica") String prob,
            @RequestParam("s1")int s1, 
            @RequestParam("s2")int s2) {
        if(checkAccess())return ERROR_PAGE;
        NonConformita newNC=new NonConformita();
        newNC.setDescrProblema(prob);
        newNC.setArticolo(articoli.findById(s1));
        newNC.setPezzo(pezzi.findById(s2));
        newNC.setDipendenteRisc(dipendente);
        newNC.setReparto("REPARTO TEMPORANEO");
        newNC.setCliente(null);
        nc.saveNonConformita(newNC);
        return "redirect:./creaSegnalazione";
    }
    @RequestMapping(value = "modifica", params = {"nr"}, method = RequestMethod.GET)
    public String modifica(ModelMap model, @RequestParam("nr") int nr) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("nc", nc.findById(nr));
        return FOLDER+"modifica";
    }
    @RequestMapping(value = "applicaModifiche", 
            params = {"nr", "verificaAzioni","verificaEfficacia", "azioniRicorrenza", "cause", "azioneContenimento", "descrSpedizione", "azioneCorrettiva", "costo"}, 
            method = RequestMethod.POST)
    public String applicaModifiche(ModelMap model, 
            @RequestParam("nr") int nr,
            @RequestParam("verificaAzioni") String verificaAzioni,
            @RequestParam("verificaEfficacia") String verificaEfficacia,
            @RequestParam("azioniRicorrenza") String azioniRicorrenza,
            @RequestParam("cause") String cause,
            @RequestParam("azioneContenimento") String azioneContenimento,
            @RequestParam("azioneCorrettiva") String azioneCorrettiva,
            @RequestParam("descrSpedizione") String descrSpedizione,
            @RequestParam("costo") Float costo, HttpSession session) {
        if(checkAccess())return ERROR_PAGE;
        if(azioneContenimento!=null&&azioneContenimento.equals(""))azioneContenimento=null;
        if(verificaAzioni!=null&&verificaAzioni.equals(""))verificaAzioni=null;
        if(verificaEfficacia!=null&&verificaEfficacia.equals(""))verificaEfficacia=null;
        if(azioniRicorrenza!=null&&azioniRicorrenza.equals(""))azioniRicorrenza=null;
        if(cause!=null&&cause.equals(""))cause=null;
        if(azioneCorrettiva!=null&&azioneCorrettiva.equals(""))azioneCorrettiva=null;
        NonConformita ncTemp=nc.findById(nr);
        ncTemp.setAzioneContenimento(azioneContenimento);
        ncTemp.setVerificaAzioni(verificaAzioni);
        ncTemp.setVerificaEfficacia(verificaEfficacia);
        ncTemp.setAzioniRicorrenza(azioniRicorrenza);
        ncTemp.setCause(cause);
        ncTemp.setAzioneContenimento(azioneContenimento);
        ncTemp.setAzioneCorrettiva(azioneCorrettiva);
        ncTemp.setCosto(new Float(costo));
        ncTemp.setDescrSpedizione(descrSpedizione);
        nc.updateNonConformita(ncTemp);
        session.removeAttribute("dipendente");
        session.setAttribute("dipendente", dipendenti.findById(dipendente.getEmail()));
        dipendente=(Dipendente)session.getAttribute("dipendente");
        return "redirect:./";
    }
    @RequestMapping(value = {"*"})
    public String error(ModelMap model) {
        return "error404";
    }
    @RequestMapping(value = { "logout"})
    public String logout(ModelMap model, HttpSession session) {
        session.removeAttribute("dipendente");
        return "redirect:../";
    }
}
