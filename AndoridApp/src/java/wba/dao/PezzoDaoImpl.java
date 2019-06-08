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
import java.util.ArrayList;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import wba.model.Pezzo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import wba.utils.GraphObjNc;

@Repository("pezzoDao")
public class PezzoDaoImpl /*extends AbstractDao<Integer, Pezzo> */ implements PezzoDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        Session s=sessionFactory.getCurrentSession();
        s.setCacheMode(CacheMode.IGNORE);
        return s;
    }

    @Override
    public Pezzo findById(int id) {
        return (Pezzo) getSession().get(Pezzo.class, id);
    }

    @Override
    public void savePezzo(Pezzo pezzo) {
        getSession().persist(pezzo);
    }

    @Override
    public void deletePezzo(int id) {
        Pezzo p = (Pezzo) getSession().load(Pezzo.class, id);
        if (p != null) {
            getSession().delete(p);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pezzo> findAllPezzo() {
        Criteria criteria = getSession().createCriteria(Pezzo.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.asc("codicePezzo"));
        return (List<Pezzo>) criteria.list();
    }

    public int getCountPezzi() {
        Criteria criteria = getSession().createCriteria(Pezzo.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setProjection(Projections.rowCount()).uniqueResult();
        return ((Long) criteria.list().get(0)).intValue();
    }
    
    public List<GraphObjNc> getPezziNc(){
        List<GraphObjNc> list= new ArrayList<>();
        
        return list;
    }
}
