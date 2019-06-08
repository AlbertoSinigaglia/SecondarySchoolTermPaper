/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wba.model.Articolo;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.model.NonConformita;
import wba.model.Pezzo;
import wba.model.Ruolo;
import wba.service.ArticoloService;
import wba.service.ClienteService;
import wba.service.DipendenteService;
import wba.service.NonConformitaService;
import wba.service.PezzoService;
import wba.utils.TrioCheckBox;

/**
 *
 * @author alberto
 */
@Controller
@RequestMapping("responsabile/")
@ComponentScan("wba.service")
@Scope("session")
public class ResponsabileController {
    Dipendente dipendente;
    private static final String ERROR_PAGE="error";
    private static final String FOLDER="responsabile/";
    @Autowired
    NonConformitaService nc;
    @Autowired ArticoloService articoli;
    @Autowired PezzoService pezzi;
    @Autowired DipendenteService dipendenti;
    @Autowired ClienteService clienti;
    @RequestMapping(value = { "/", "homepage"})
    public String homepage(ModelMap model, HttpSession session) {
        dipendente=(Dipendente)session.getAttribute("dipendente");
        if (checkAccess()) return ERROR_PAGE;
        model.addAttribute("nomeDip", dipendente.getNome()+" "+dipendente.getCognome());
        model.addAttribute("nAperte", nc.getCountAperte());
        model.addAttribute("nEsec", nc.getCountEsec());
        model.addAttribute("nChiuse", nc.getCountChiuse());
        model.addAttribute("dataLA",nc.getLastLA());
        model.addAttribute("dataLE",nc.getLastLE());
        model.addAttribute("dataLC", nc.getLastLC());
        model.addAttribute("nPezzi", pezzi.getCountPezzi());
        model.addAttribute("nArticoli", articoli.getCountArticoli());
        return FOLDER+"index";
    }
    @RequestMapping(value = "aperte", method = RequestMethod.GET)
    public String aperte(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("nc", nc.findAllOpenNC());
        return FOLDER+"nonConformita";
    }
    @RequestMapping(value = "chiuse", method = RequestMethod.GET)
    public String chiuse(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("nc", nc.findAllCloseNC());
        return FOLDER+"nonConformita";
    }
    @RequestMapping(value = "esec", method = RequestMethod.GET)
    public String esec(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("nc", nc.findAllInEsecNC());
        return FOLDER+"nonConformita";
    }
    @RequestMapping(value = "infoNC", params = {"nr"}, method = RequestMethod.GET)
    public String infoNC(ModelMap model, @RequestParam("nr") int nr) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("nc", nc.findById(nr));
        return FOLDER+"infoNC";
    }
    @RequestMapping(value = "creaSegnalazione", method = RequestMethod.GET)
    public String creaSegnalazione(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("articoli", articoli.findAllArticolo());
        map.addAttribute("segnalazioni", nc.findAllSegn());
        return FOLDER+"creaSegnalazione";
    }
    @RequestMapping(value = "clidip", method = RequestMethod.GET)
    public String clidip(ModelMap map) {
        if (checkAccess()) return ERROR_PAGE;
        map.addAttribute("dipendenti", dipendenti.findOnlyDipendenti());
        map.addAttribute("clienti", clienti.findOnlyClienti());
        return FOLDER+"clidip";
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
        newNC.setDataInizio(null);
        newNC.setDipendentiGest(null);
        nc.saveNonConformita(newNC);
        return "redirect:./creaSegnalazione";
    }
    @RequestMapping(value = "gestisci", params = {"nr"}, method = RequestMethod.GET)
    public String gestisci(ModelMap model, @RequestParam("nr")int nr) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("nr", nr);
        model.addAttribute("segn", nc.findById(nr));
        model.addAttribute("dipendenti", dipendenti.findOnlyDipendenti());
        return FOLDER+"gestione";
    }
    @RequestMapping(value = "infoDip", params = {"email"}, method = RequestMethod.GET)
    public String infoDip(ModelMap model, @RequestParam("email")String email) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("dip", dipendenti.findById(email));
        return FOLDER+"infoDip";
    }
    @RequestMapping(value = "infoCli", params = {"piva"}, method = RequestMethod.GET)
    public String infoCli(ModelMap model, @RequestParam("piva")String piva) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("cli", clienti.findById(piva));
        return FOLDER+"infoCli";
    }
    @RequestMapping(value = "reclami")
    public String reclami(ModelMap model) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("reclami", nc.findAllReclami());
        return FOLDER+"reclami";
    }
    @RequestMapping(value = "convalidaGestione", params = {"dip", "nr"}, method = RequestMethod.POST)
    public String convalidaGestione(ModelMap model, @RequestParam("dip")String[] dipendentiGest,@RequestParam("nr")int nr) {
        if(checkAccess())return ERROR_PAGE;
        NonConformita tmp=nc.findById(nr);
        tmp.setDataInizio(new Date());
        nc.updateNonConformita(tmp);
        for(String dip: dipendentiGest){
            Dipendente d=dipendenti.findById(dip);
            Set<NonConformita> s= d.getNonConfGest();
            s.add(tmp);
            d.setNonConfGest(s);
            dipendenti.updateDipendente(d);
        }
        model.addAttribute("dipendenti", nc.findById(nr).getDipendentiGest());
        return "redirect:./";
    }
    private boolean checkAccess(){
        return dipendente==null||dipendente.getRuolo()!=Ruolo.ResponsabileNC;
    }
    @RequestMapping(value = "modifica", params = {"nr"}, method = RequestMethod.GET)
    public String modifica(ModelMap model, @RequestParam("nr") int nr) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("nc", nc.findById(nr));
        return FOLDER+"modifica";
    }
    @RequestMapping(value = "statistiche", method = RequestMethod.GET)
    public String modifica(ModelMap model) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("andamento", nc.getOnlyNc());
        model.addAttribute("anno", Calendar.getInstance().get(Calendar.YEAR));
        model.addAttribute("pezziNC", pezzi.getPezziNc());
        model.addAttribute("articoliNC", articoli.getArticoliNc());
        return FOLDER+"statistiche";
    }
    @RequestMapping(value = "applicaModifiche", 
            params = {"nr", "verificaAzioni","verificaEfficacia", "azioniRicorrenza", "cause", "azioneContenimento", "azioneCorrettiva", "costo", "descrSpedizione"}, 
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
            @RequestParam("costo") Float costo) {
        if(checkAccess())return ERROR_PAGE;
        NonConformita ncTemp=nc.findById(nr);
        if(azioneContenimento!=null&&azioneContenimento.equals(""))azioneContenimento=null;
        if(verificaAzioni!=null&&verificaAzioni.equals(""))verificaAzioni=null;
        if(verificaEfficacia!=null&&verificaEfficacia.equals(""))verificaEfficacia=null;
        if(azioniRicorrenza!=null&&azioniRicorrenza.equals(""))azioniRicorrenza=null;
        if(cause!=null&&cause.equals(""))cause=null;
        if(azioneCorrettiva!=null&&azioneCorrettiva.equals(""))azioneCorrettiva=null;
        ncTemp.setVerificaAzioni(verificaAzioni);
        ncTemp.setVerificaEfficacia(verificaEfficacia);
        ncTemp.setCosto(costo);
        ncTemp.setAzioniRicorrenza(azioniRicorrenza);
        ncTemp.setCause(cause);
        ncTemp.setAzioneContenimento(azioneContenimento);
        ncTemp.setAzioneCorrettiva(azioneCorrettiva);
        ncTemp.setDescrSpedizione(descrSpedizione);
        nc.updateNonConformita(ncTemp);
        return "redirect:./";
    }
    @RequestMapping(value = "richiesteProfilo", method = RequestMethod.GET)
    public String richiesteProfilo(ModelMap model) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("richiesteDip", dipendenti.findRichieste());
        model.addAttribute("richiesteCli", clienti.findRichieste());
        return FOLDER+"richiesteProfilo";
    }
    @RequestMapping(value = "accettaRichiesta", params = {"email"}, method = RequestMethod.GET)
    public String accettaRichiestaDip(ModelMap model, @RequestParam("email") String email) {
        if(checkAccess())return ERROR_PAGE;
        Dipendente dip= dipendenti.findById(email);
        dip.setAccettato(true);
        dipendenti.updateDipendente(dip);
        return "redirect:./richiesteProfilo";
    }
    @RequestMapping(value = "accettaRichiesta", params = {"piva"}, method = RequestMethod.GET)
    public String accettaRichiestaCli(ModelMap model, @RequestParam("piva") String piva) {
        if(checkAccess())return ERROR_PAGE;
        Cliente cli= clienti.findById(piva);
        cli.setAccettato(true);
        clienti.updateCliente(cli);
        return "redirect:./richiesteProfilo";
    }
    @RequestMapping(value = "chiudi", params = {"nr"}, method = RequestMethod.GET)
    public String chiudi(ModelMap model, @RequestParam("nr") int nr) {
        if(checkAccess())return ERROR_PAGE;
        NonConformita tmp= nc.findById(nr);
        tmp.setDataFine(new Date());
        nc.updateNonConformita(tmp);
        model.addAttribute("nc", nc.findAllCloseNC());
        return FOLDER+"nonConformita";
    }
    @RequestMapping(value = "pezzi", method = RequestMethod.GET)
    public String pezzi(ModelMap model) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("pezzi", pezzi.findAllPezzo());
        return FOLDER+"pezzi";
    }
    @RequestMapping(value = "pezzi", params = {"id"}, method = RequestMethod.GET)
    public String pezzi(ModelMap model, @RequestParam("id") int id) {
        if(checkAccess())return ERROR_PAGE;
        model.addAttribute("pezzi", pezzi.findAllPezzo());
        model.addAttribute("pezzo", pezzi.findById(id));
        return FOLDER+"pezzi";
    }
    @RequestMapping(value = "addPezzo", params = {"nome", "descrizione"}, method = RequestMethod.POST)
    public String addPezzo(ModelMap model, @RequestParam("nome") String nome, @RequestParam("descrizione") String descrizione ) {
        if(checkAccess())return ERROR_PAGE;
        Pezzo pz= new Pezzo();
        pz.setNome(nome);
        pz.setDescrizione(descrizione);
        pezzi.savePezzo(pz);
        model.addAttribute("pezzi", pezzi.findAllPezzo());
        return FOLDER+"pezzi";
    }
    @RequestMapping(value = "modificaPezzo", params = {"nr","nome", "descrizione"}, method = RequestMethod.POST)
    public String modificaPezzo(ModelMap model, @RequestParam("nr") int nr, @RequestParam("nome") String nome, @RequestParam("descrizione") String descrizione ) {
        if(checkAccess())return ERROR_PAGE;
        Pezzo pz= new Pezzo();
        pz.setNome(nome);
        pz.setDescrizione(descrizione);
        pz.setCodicePezzo(nr);
        pezzi.updatePezzo(pz);
        model.addAttribute("pezzi", pezzi.findAllPezzo());
        return FOLDER+"pezzi";
    }
    @RequestMapping(value = "articoli", method = RequestMethod.GET)
    public String articoli(ModelMap model) {
        if(checkAccess())return ERROR_PAGE;
        List<TrioCheckBox> lista= new ArrayList<>();
        for(Pezzo pz: pezzi.findAllPezzo()) lista.add(new TrioCheckBox(pz.getCodicePezzo(),pz.getNome(), false));
        model.addAttribute("pezzi", lista);
        model.addAttribute("articoli", articoli.findAllArticolo());
        return FOLDER+"articoli";
    }
    @RequestMapping(value = "articoli", params = {"id"}, method = RequestMethod.GET)
    public String articoli(ModelMap model, @RequestParam("id") int id) {
        if(checkAccess())return ERROR_PAGE;
        List<TrioCheckBox> lista= new ArrayList<>();
        for(Pezzo pezzo: pezzi.findAllPezzo()){
            boolean tmp=false;
            for(Pezzo pz: articoli.findById(id).getPezzi()){
                if(pz.getCodicePezzo()==pezzo.getCodicePezzo()) tmp=true;
            }
            lista.add(new TrioCheckBox(pezzo.getCodicePezzo(), pezzo.getNome(), tmp));
        }
        model.addAttribute("pezzi", lista);
        model.addAttribute("articoli", articoli.findAllArticolo());
        model.addAttribute("articolo", articoli.findById(id));
        return FOLDER+"articoli";
    }
    @RequestMapping(value = "addArticolo", params = {"nome", "descrizione"}, method = RequestMethod.POST)
    public String addArticolo(ModelMap model, @RequestParam("nome") String nome, @RequestParam("descrizione") String descrizione ) {
        if(checkAccess())return ERROR_PAGE;
        Articolo art= new Articolo();
        art.setNome(nome);
        art.setDescrizione(descrizione);
        articoli.saveArticolo(art);
        List<TrioCheckBox> lista= new ArrayList<>();
        for(Pezzo pz: pezzi.findAllPezzo()) lista.add(new TrioCheckBox(pz.getCodicePezzo(),pz.getNome(), false));
        model.addAttribute("pezzi", lista);
        model.addAttribute("articoli", articoli.findAllArticolo());
        return FOLDER+"articoli";
    }
    @RequestMapping(value = "modificaArticolo", params = {"nr","nome", "descrizione", "pezzi"}, method = RequestMethod.POST)
    public String modificaArticolo(ModelMap model, @RequestParam("nr") int nr, @RequestParam("nome") String nome, @RequestParam("descrizione") String descrizione, @RequestParam("pezzi") Integer[] pezzi ) {
        if(checkAccess())return ERROR_PAGE;
        Articolo art= new Articolo();
        art.setNome(nome);
        art.setDescrizione(descrizione);
        art.setCodiceArticolo(nr);
        Set<Pezzo> set= new HashSet<>();
        for(int id: pezzi) set.add(this.pezzi.findById(id));
        art.setPezzi(set);
        articoli.updateArticolo(art);
        List<TrioCheckBox> lista= new ArrayList<>();
        for(Pezzo pz: this.pezzi.findAllPezzo()) lista.add(new TrioCheckBox(pz.getCodicePezzo(),pz.getNome(), false));
        model.addAttribute("pezzi", lista);
        model.addAttribute("articoli", articoli.findAllArticolo());
        return FOLDER+"articoli";
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
