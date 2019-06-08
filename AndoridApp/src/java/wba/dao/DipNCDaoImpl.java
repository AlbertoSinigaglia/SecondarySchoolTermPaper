/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.dao;

import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wba.model.Articolo;
import wba.model.DipNc;
import wba.model.Dipendente;

/**
 *
 * @author albertosinigaglia
 */
@Repository("dipNcDao")
public class DipNCDaoImpl /*extends AbstractDao<Integer, Articolo> */implements DipNCDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        Session s=sessionFactory.getCurrentSession();
        s.setCacheMode(CacheMode.IGNORE);
        return s;
    }
    @Override
    public List<DipNc> findByNC(Integer id) {
        Criteria criteria = getSession().createCriteria(DipNc.class);
        criteria.add(Restrictions.eq("nr", id));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<DipNc>) criteria.list();
    }
}