/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.service;

import com.vetisolutions.smartcal.administrationmanager.dao.IEnseignantDao;
import com.vetisolutions.smartcalc.entities.Enseignant;
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
public class EnseignantService {
    
    @Autowired
    private IEnseignantDao enseignantDao;
    
    public Enseignant create(Enseignant en){
        return enseignantDao.save(en);
    }
    public Page<Enseignant> findAll(int from, int to){
        return enseignantDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "id")));
    }
    
    public Enseignant update(Enseignant en){
        return enseignantDao.save(en);
    }
    
    public void delete(long id){
        enseignantDao.deleteById(id);
    }
    
}
