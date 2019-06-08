/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wba.dao.DipendenteDao;
import wba.model.Dipendente;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */

@Service("dipendenteService")
@Transactional
public class DipendenteServiceImpl implements DipendenteService {
 
    @Autowired
    private DipendenteDao dao;
     
    @Override
    public Dipendente findById(String id) {
        return dao.findById(id);
    }
 
    @Override
    public void saveDipendente(Dipendente dipendente) {
        dao.saveDipendente(dipendente);
    }
 
    @Override
    public void updateDipendente(Dipendente dipendente) {
        Dipendente entity = dao.findById(dipendente.getEmail());
        if(entity!=null){
            entity.setNome(dipendente.getNome());
            entity.setCognome(dipendente.getCognome());
            entity.setTel(dipendente.getTel());
            entity.setTel2(dipendente.getTel2());
            entity.setRuolo(dipendente.getRuolo());
            entity.setAccettato(dipendente.getAccettato());
        }
    }
 
    @Override
    public void deleteDipendente(String id) {
        dao.deleteDipendente(id);
    }
     
    @Override
    public List<Dipendente> findAllDipendente() {
        return dao.findAllDipendente();
    }   
    @Override
    public List<Dipendente> findOnlyDipendenti(){
        return dao.findOnlyDipendenti();
    }
    @Override
    public List<Dipendente> findRichieste(){
        return dao.findRichieste();
    }
}
