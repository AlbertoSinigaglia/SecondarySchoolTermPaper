/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.dao;

import java.util.List;
import wba.model.Articolo;
import wba.utils.GraphObjNc;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
public interface ArticoloDao {
    Articolo findById(int id);
    void saveArticolo(Articolo articolo);
    void deleteArticolo(int id);
    List<Articolo> findAllArticolo();
    public int getCountArticoli();
    public List<GraphObjNc> getArticoliNc();
 }
