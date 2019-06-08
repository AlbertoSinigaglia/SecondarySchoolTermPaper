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

import java.util.List;
import wba.model.Pezzo;
import wba.utils.GraphObjNc;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
public interface PezzoService {
    Pezzo findById(int id);
    void savePezzo(Pezzo pezzo);
    void updatePezzo(Pezzo pezzo);
    void deletePezzo(int id);
    public int getCountPezzi();
    List<Pezzo> findAllPezzo(); 
    public List<GraphObjNc> getPezziNc();
}

