/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.service;

import com.vetisolutions.smartcal.administrationmanager.dao.IClasseDao;
import com.vetisolutions.smartcalc.entities.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vaka
 */
@Service
@Transactional
public class ClasseService {
    
    @Autowired
    private IClasseDao classeDao;
    
    public Classe create(Classe cl){
        return classeDao.save(cl);
    }
    
    public Classe update(Classe cl){
        return classeDao.save(cl);
    }
    
    public Page<Classe> findAll(int from, int to){
        return classeDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "id")));
    }
    
    public void delete(long id){
        classeDao.deleteById(id);
    }
    
}
