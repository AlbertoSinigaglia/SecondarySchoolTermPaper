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
import wba.dao.PezzoDao;
import wba.model.Pezzo;
import wba.utils.GraphObjNc;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
@Service("pezzoService")
@Transactional
public class PezzoServiceImpl implements PezzoService {
 
    @Autowired
    private PezzoDao dao;
     
    @Override
    public Pezzo findById(int id) {
        return dao.findById(id);
    }
 
    @Override
    public void savePezzo(Pezzo pezzo) {
        dao.savePezzo(pezzo);
    }
 
    @Override
    public void updatePezzo(Pezzo pezzo) {
        Pezzo entity = dao.findById(pezzo.getCodicePezzo());
        if(entity!=null){
            entity.setNome(pezzo.getNome());
            entity.setDescrizione(pezzo.getDescrizione());
        }
    }
 
    @Override
    public void deletePezzo(int id) {
        dao.deletePezzo(id);
    }
     
    @Override
    public List<Pezzo> findAllPezzo() {
        return dao.findAllPezzo();
    }   
    public int getCountPezzi(){
        return dao.getCountPezzi();
    }
    public List<GraphObjNc> getPezziNc(){
        return dao.getPezziNc();
    }
}