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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import wba.model.NonConformita;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import wba.model.Cliente;
import wba.model.Dipendente;
import wba.utils.GraphDateCount;

@Repository("nonConformitaDao")
public class NonConformitaDaoImpl /*extends AbstractDao<Integer, NonConformita> */ implements NonConformitaDao {
    @Autowired
    private SessionFactory sessionFactory;
    protected Session getSession(){
        Session s=sessionFactory.getCurrentSession();
        s.setCacheMode(CacheMode.IGNORE);
        return s;
    }
    /**
     * METODI COMUNI A TUTTI I DAO
     */
    @Override
    public NonConformita findById(int id) {
        return (NonConformita) getSession().get(NonConformita.class, id);
    }
    @Override
    public void saveNC(NonConformita nonConformita) {
        getSession().persist(nonConformita);
    }
    @Override
    public void deleteNC(int id) {
        NonConformita nc = (NonConformita) getSession().load(NonConformita.class, id);
        if (nc != null) {
            getSession().delete(nc);
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<NonConformita> findAllNC() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<NonConformita>) criteria.list();
    }
    @Override
    public void updateNC(NonConformita nc) {
        getSession().update(nc);
    }
    
    
    
    
    /**
     * OTTENERE TUTTE LE NC DI UNA DETERMINATA FASE 
     */
    @Override
    public List<NonConformita> findAllOpenNC() {
        Criteria criteria = this.getAperteCriteria();
        criteria.addOrder(Order.desc("nr"));
        return (List<NonConformita>) criteria.list();
    }
    @Override
    public List<NonConformita> findAllCloseNC() {
        Criteria criteria = this.getChiuseCriteria();
        criteria.addOrder(Order.desc("nr"));
        return (List<NonConformita>) criteria.list();
    }
    @Override
    public List<NonConformita> findAllInEsecNC() {
        Criteria criteria = this.getEsecCriteria();
        criteria.addOrder(Order.desc("nr"));
        return (List<NonConformita>) criteria.list();
    }

    
    
    
    /**
     * OTTENERE LE NC CHE NON SON ANCORA STATE APERTE
     */
    @Override
    public List<NonConformita> findAllSegn() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNull("dataInizio"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.desc("nr"));
        criteria.add(Restrictions.isNull("cliente"));
        return (List<NonConformita>) criteria.list();
    }
    @Override
    public List<NonConformita> findAllSegnByDip(Dipendente dip) {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNull("dataInizio"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.desc("nr"));
        criteria.add(Restrictions.isNull("cliente")).add(Restrictions.eq("dipendenteRisc", dip));
        return (List<NonConformita>) criteria.list();
    }
    @Override
    public List<NonConformita> findAllReclami() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNull("dataInizio"));
        criteria.add(Restrictions.isNull("dipendenteRisc"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<NonConformita>) criteria.list();
    }
    @Override
    public List<NonConformita> findAllReclamiGest(Cliente cli) {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNotNull("dataInizio"));
        criteria.add(Restrictions.eq("cliente", cli));
        criteria.add(Restrictions.isNull("dipendenteRisc"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<NonConformita>) criteria.list();
    }
    @Override
    public List<NonConformita> findAllReclamiNonGest(Cliente cli) {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNull("dataInizio"));
        criteria.add(Restrictions.eq("cliente", cli));
        criteria.add(Restrictions.isNull("dipendenteRisc"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<NonConformita>) criteria.list();
    }

    
    
    
    /**
     * OTTENERE LA DATA DELL'ULTIMA NC DI UNA CATEGORIA 
     */
    @Override
    public Date getLastLA() {
        Criteria criteria = this.getAperteCriteria();
        criteria.setProjection(Projections.max("dataInizio"));
        Date data = (Date) criteria.list().get(0);
        return data;
    }
    @Override
    public Date getLastLC() {
        Criteria criteria = this.getChiuseCriteria();
        criteria.setProjection(Projections.max("dataInizio"));
        Date data = (Date) criteria.list().get(0);
        return data;
    }
    @Override
    public Date getLastLE() {
        Criteria criteria = this.getEsecCriteria();
        criteria.setProjection(Projections.max("dataInizio"));
        Date data = (Date) criteria.list().get(0);
        return data;
    }

    
    
    
    /**
     * OTTENERE NUMERO DI NC DI UNA CATEGORIA
     */
    public int getCountAperte(){
        Criteria criteria= this.getAperteCriteria();
        criteria.setProjection(Projections.rowCount()).uniqueResult();
        return ((Long)criteria.list().get(0)).intValue();
    }
    public int getCountEsec(){
        Criteria criteria= this.getEsecCriteria();
        criteria.setProjection(Projections.rowCount()).uniqueResult();
        return ((Long)criteria.list().get(0)).intValue();
    }
    public int getCountChiuse(){
        Criteria criteria= this.getChiuseCriteria();
        criteria.setProjection(Projections.rowCount()).uniqueResult();
        return ((Long)criteria.list().get(0)).intValue();
    }
    
    
    
    public List<ArrayList> getOnlyNc(){
        ArrayList<ArrayList> tot= new ArrayList<>();
        for(int year=2016; year<= Calendar.getInstance().get(Calendar.YEAR); year++){
            ArrayList<GraphDateCount> list= new ArrayList<>();
            for(int i=0; i<12; i++){
                Calendar cal = GregorianCalendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, i);  
                cal.set(Calendar.DAY_OF_MONTH,1);
                Date di = cal.getTime();
                cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                Date df= cal.getTime();
                Criteria tmp= getSession().createCriteria(NonConformita.class);
                tmp.add(Restrictions.ge("dataInizio", di)).add(Restrictions.le("dataInizio", df)).add(Restrictions.isNotNull("dataInizio"));
                tmp.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                tmp.setProjection(Projections.rowCount()).uniqueResult();
                int c= ((Long)tmp.list().get(0)).intValue();
                list.add(new GraphDateCount(cal.get(Calendar.MONTH), c));
            }
            tot.add(list);
        }
        return tot;
    }
    /**
     * OTTENERE CRITERIA DI UNA DETERMINATA CATEGORIA 
     */
    private Criteria getAperteCriteria() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        Criterion cri1 = Restrictions.isNotNull("dataInizio");
        Criterion cri2 = Restrictions.isNull("dataFine");
        Criterion t1 = Restrictions.and(cri1, cri2);
        Criterion cri3 = Restrictions.isNull("azioneContenimento");
        criteria.add(Restrictions.and(t1, cri3));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }
    private Criteria getChiuseCriteria() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        criteria.add(Restrictions.isNotNull("dataFine"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }
    private Criteria getEsecCriteria() {
        Criteria criteria = getSession().createCriteria(NonConformita.class);
        Criterion cri1 = Restrictions.isNotNull("dataInizio");
        Criterion cri2 = Restrictions.isNull("dataFine");
        Criterion t1 = Restrictions.and(cri1, cri2);
        Criterion cri3 = Restrictions.isNotNull("azioneContenimento");
        criteria.add(Restrictions.and(t1, cri3));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }
}
