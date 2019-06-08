/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.dao;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import wba.model.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("clienteDao")
public class ClienteDaoImpl /*extends AbstractDao<Integer, Cliente> */implements ClienteDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        Session s=sessionFactory.getCurrentSession();
        s.setCacheMode(CacheMode.IGNORE);
        return s;
    }
    @Override
    public Cliente findById(String id) {
            return (Cliente) getSession().get(Cliente.class, id);
    }
    @Override
    public void saveCliente(Cliente cliente) {
        getSession().persist(cliente);
    }
    @Override
    public void deleteCliente(String id) {
        Cliente c = (Cliente) getSession().load(Cliente.class, id);
	if(c!=null) getSession().delete(c);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAllCliente() {
       Criteria criteria = getSession().createCriteria(Cliente.class);
       criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Cliente>) criteria.list();
    }
    @Override
    public List<Cliente> findRichieste(){
        Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("accettato", false));
        criteria.addOrder(Order.desc("piva"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Cliente>) criteria.list();
    }
    public List<Cliente> findOnlyClienti(){
        Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("accettato", true));
        criteria.addOrder(Order.asc("azienda"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Cliente>) criteria.list();
    }
}

