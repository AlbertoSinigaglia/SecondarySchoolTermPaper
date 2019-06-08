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
import wba.dao.ClienteDao;
import wba.model.Cliente;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {
 
    @Autowired
    private ClienteDao dao;
     
    @Override
    public Cliente findById(String id) {
        return dao.findById(id);
    }
 
    @Override
    public void saveCliente(Cliente cliente) {
        dao.saveCliente(cliente);
    }
 
    @Override
    public void updateCliente(Cliente cliente) {
        Cliente entity = dao.findById(cliente.getPiva());
        if(entity!=null){
            entity.setEmail(cliente.getEmail());
            entity.setTel(cliente.getTel());
            entity.setTel2(cliente.getTel2());
            entity.setAzienda(cliente.getAzienda());
            entity.setNc(cliente.getNc());
            entity.setAccettato(cliente.getAccettato());
        }
    }
 
    @Override
    public void deleteCliente(String id) {
        dao.deleteCliente(id);
    }
     
    @Override
    public List<Cliente> findAllCliente() {
        return dao.findAllCliente();
    }   
    @Override
    public List<Cliente> findRichieste(){
        return dao.findRichieste();
    }
    public List<Cliente> findOnlyClienti(){
        return dao.findOnlyClienti();
    }
}
