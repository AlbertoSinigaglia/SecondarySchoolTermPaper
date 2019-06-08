/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.dao;

import java.util.List;
import wba.model.Pezzo;
import wba.utils.GraphObjNc;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
public interface PezzoDao {
    Pezzo findById(int id);
    void savePezzo(Pezzo pezzo);
    void deletePezzo(int id);
    List<Pezzo> findAllPezzo();
    public int getCountPezzi();
    public List<GraphObjNc> getPezziNc();
 }
