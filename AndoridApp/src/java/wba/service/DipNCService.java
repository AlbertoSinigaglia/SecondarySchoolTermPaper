/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.service;

import java.util.List;
import wba.model.DipNc;

/**
 *
 * @author albertosinigaglia
 */
public interface DipNCService {
    public List<DipNc> findByNC(Integer id);
}
