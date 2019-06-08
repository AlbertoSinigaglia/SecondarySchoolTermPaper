/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wba.dao.ArticoloDao;
import wba.dao.DipNCDao;
import wba.model.Articolo;
import wba.model.DipNc;

/**
 *
 * @author albertosinigaglia
 */
@Service("dipNcService")
@Transactional
public class DipNCServiceImpl implements DipNCService {
 
    @Autowired
    private DipNCDao dao;
     
    public List<DipNc> findByNC(Integer id) {
        return dao.findByNC(id);
    }  
}
