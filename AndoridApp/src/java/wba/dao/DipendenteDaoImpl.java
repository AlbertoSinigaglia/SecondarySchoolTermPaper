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
import wba.model.Dipendente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import wba.model.Ruolo;
 
@Repository("dipendenteDao")
public class DipendenteDaoImpl /*extends AbstractDao<Integer, Dipendente> */implements DipendenteDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        Session s=sessionFactory.getCurrentSession();
        s.setCacheMode(CacheMode.IGNORE);
        return s;
    }
    @Override
    public Dipendente findById(String id) {
            return (Dipendente) getSession().get(Dipendente.class, id);
            
    }
    @Override
    public void saveDipendente(Dipendente dipendente) {
        getSession().persist(dipendente);
    }
    @Override
    public void deleteDipendente(String id) {
        Dipendente d = (Dipendente) getSession().load(Dipendente.class, id);
	if(d!=null) getSession().delete(d);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Dipendente> findAllDipendente() {
       Criteria criteria = getSession().createCriteria(Dipendente.class);
       criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Dipendente>) criteria.list();
    }
    @Override
    public List<Dipendente> findOnlyDipendenti() {
       Criteria criteria = getSession().createCriteria(Dipendente.class);
       criteria.add(Restrictions.eq("ruolo", Ruolo.AltriRuoli)).add(Restrictions.eq("accettato", true));
       criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
       criteria.addOrder(Order.asc("nome"));
        return (List<Dipendente>) criteria.list();
    }
    @Override
    public List<Dipendente> findRichieste(){
        Criteria criteria = getSession().createCriteria(Dipendente.class);
        criteria.add(Restrictions.eq("accettato", false));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.desc("email"));
        return (List<Dipendente>) criteria.list();
    }
 
}

