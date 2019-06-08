/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wba.dao.NonConformitaDao;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.model.NonConformita;
import wba.utils.GraphDateCount;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */

@Service("ncService")
@Transactional
public class NonConformitaServiceImpl implements NonConformitaService {
 
    @Autowired
    private NonConformitaDao dao;
     
    @Override
    public NonConformita findById(int id) {
        return dao.findById(id);
    }
 
    @Override
    public void saveNonConformita(NonConformita nc) {
        dao.saveNC(nc);
    }
 
    @Override
    public NonConformita updateNonConformita(NonConformita nc) {
        NonConformita entity = dao.findById(nc.getNr());
        if(entity!=null){
            entity.setVerificaEfficacia(nc.getVerificaEfficacia());
            entity.setVerificaAzioni(nc.getVerificaAzioni());
            entity.setAzioniRicorrenza(nc.getAzioniRicorrenza());
            entity.setReparto(nc.getReparto());
            entity.setDataInizio(nc.getDataInizio());
            entity.setDataFine(nc.getDataFine());
            entity.setCause(nc.getCause());
            entity.setDescrSpedizione(nc.getDescrSpedizione());
            entity.setCosto(nc.getCosto());
            entity.setDescrProblema(nc.getDescrProblema());
            entity.setAzioneContenimento(nc.getAzioneContenimento());
            entity.setAzioneCorrettiva(nc.getAzioneCorrettiva());
        }
        return entity;
    }
 
    @Override
    public void deleteNonConformita(int id) {
        dao.deleteNC(id);
    }
     
    @Override
    public List<NonConformita> findAllNonConformita() {
        return dao.findAllNC();
    }   
    @Override
    public List<NonConformita> findAllOpenNC(){
        return dao.findAllOpenNC();
    }
    @Override
    public List<NonConformita> findAllCloseNC(){
        return dao.findAllCloseNC();
    }
    @Override
    public List<NonConformita> findAllSegn(){
        return dao.findAllSegn();
    }
    @Override
    public List<NonConformita> findAllInEsecNC(){
        return dao.findAllInEsecNC();
    }
    @Override
    public Date getLastLC(){
        return dao.getLastLC();
    }
    @Override
    public Date getLastLA(){
        return dao.getLastLA();
    }
    @Override
    public Date getLastLE(){
        return dao.getLastLE();
    }
    @Override
    public void updateNC(NonConformita nc){
        dao.updateNC(nc);
    }
    @Override
    public int getCountAperte(){
        return dao.getCountAperte();
    }
    @Override
    public int getCountEsec(){
        return dao.getCountEsec();
    }
    @Override
    public int getCountChiuse(){
        return dao.getCountChiuse();
    }
    @Override
    public List<NonConformita> findAllReclamiGest(Cliente cli){
        return dao.findAllReclamiGest(cli);
    }
    @Override
    public List<NonConformita> findAllReclamiNonGest(Cliente cli){
        return dao.findAllReclamiNonGest(cli);
    }
    @Override
    public List<NonConformita> findAllReclami(){
        return dao.findAllReclami();
    }
    @Override
    public List<ArrayList> getOnlyNc(){
        return dao.getOnlyNc();
    }
    public List<NonConformita> findAllSegnByDip(Dipendente dip){
        return dao.findAllSegnByDip(dip);
    }
}

