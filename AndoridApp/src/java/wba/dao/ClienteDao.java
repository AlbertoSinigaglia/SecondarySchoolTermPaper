package wba.dao;

import java.util.List;
import wba.model.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
public interface ClienteDao {
    Cliente findById(String piva);
    void saveCliente(Cliente cliente);
    void deleteCliente(String piva);
    List<Cliente> findAllCliente();
    public List<Cliente> findRichieste();
    public List<Cliente> findOnlyClienti();
 }