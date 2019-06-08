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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wba.dao.ArticoloDao;
import wba.model.Articolo;
import wba.utils.GraphObjNc;

@Service("articoloService")
@Transactional
public class ArticoloServiceImpl implements ArticoloService {
 
    @Autowired
    private ArticoloDao dao;
     
    @Override
    public Articolo findById(int id) {
        return dao.findById(id);
    }
 
    @Override
    public void saveArticolo(Articolo articolo) {
        dao.saveArticolo(articolo);
    }
 
    @Override
    public void updateArticolo(Articolo articolo) {
        Articolo entity = dao.findById(articolo.getCodiceArticolo());
        if(entity!=null){
            entity.setNome(articolo.getNome());
            entity.setDescrizione(articolo.getDescrizione());
        }
    }
 
    @Override
    public void deleteArticolo(int id) {
        dao.deleteArticolo(id);
    }
     
    @Override
    public List<Articolo> findAllArticolo() {
        return dao.findAllArticolo();
    }   
    public int getCountArticoli(){
        return dao.getCountArticoli();
    }
    public List<GraphObjNc> getArticoliNc(){
        return dao.getArticoliNc();
    }
}
