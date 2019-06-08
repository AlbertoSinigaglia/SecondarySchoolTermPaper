/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.service;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.model.NonConformita;
import wba.utils.GraphDateCount;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
public interface NonConformitaService {
    NonConformita findById(int id);
    void saveNonConformita(NonConformita nc);
    NonConformita updateNonConformita(NonConformita nc);
    void deleteNonConformita(int id);
    List<NonConformita> findAllNonConformita(); 
    List<NonConformita> findAllOpenNC();
    List<NonConformita> findAllCloseNC();
    List<NonConformita> findAllSegn();
    List<NonConformita> findAllInEsecNC();
    public Date getLastLC();
    public Date getLastLA();
    public Date getLastLE();
    public List<NonConformita> findAllReclami();
    public void updateNC(NonConformita nc);
    public int getCountAperte();
    public int getCountEsec();
    public int getCountChiuse();
    public List<NonConformita> findAllReclamiGest(Cliente cli);
    public List<NonConformita> findAllReclamiNonGest(Cliente cli);
    public List<ArrayList> getOnlyNc();
    public List<NonConformita> findAllSegnByDip(Dipendente dip);
}

