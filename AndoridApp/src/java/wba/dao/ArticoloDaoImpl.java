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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.ArrayList;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import wba.model.Articolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import wba.model.Pezzo;
import wba.utils.GraphObjNc;
 
@Repository("articoloDao")
public class ArticoloDaoImpl /*extends AbstractDao<Integer, Articolo> */implements ArticoloDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        Session s=sessionFactory.getCurrentSession();
        s.setCacheMode(CacheMode.IGNORE);
        return s;
    }
    @Override
    public Articolo findById(int id) {
            return (Articolo) getSession().get(Articolo.class, id);
    }
    @Override
    public void saveArticolo(Articolo articolo) {
        getSession().persist(articolo);
    }
    @Override
    public void deleteArticolo(int id) {
        Articolo a = (Articolo) getSession().load(Articolo.class, id);
	if(a!=null) getSession().delete(a);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Articolo> findAllArticolo() {
       Criteria criteria = getSession().createCriteria(Articolo.class);
       criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
       criteria.addOrder(Order.asc("codiceArticolo"));
        return (List<Articolo>) criteria.list();
    }
    public int getCountArticoli() {
        Criteria criteria = getSession().createCriteria(Articolo.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setProjection(Projections.rowCount()).uniqueResult();
        return ((Long) criteria.list().get(0)).intValue();
    }
    public List<GraphObjNc> getArticoliNc(){
        List<GraphObjNc> list= new ArrayList<>();
        
        return list;
    }
}
