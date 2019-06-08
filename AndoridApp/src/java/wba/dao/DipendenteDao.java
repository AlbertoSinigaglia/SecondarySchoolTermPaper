/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.dao;

import java.util.List;
import wba.model.Dipendente;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
public interface DipendenteDao {
    Dipendente findById(String id);
    void saveDipendente(Dipendente dipendente);
    void deleteDipendente(String id);
    List<Dipendente> findAllDipendente();
    public List<Dipendente> findOnlyDipendenti();
    public List<Dipendente> findRichieste();
 }
