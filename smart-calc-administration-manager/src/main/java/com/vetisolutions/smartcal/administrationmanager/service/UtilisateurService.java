/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.service;

import com.vetisolutions.smartcal.administrationmanager.dao.IUtilisateurDao;
import com.vetisolutions.smartcalc.entities.Enseignant;
import com.vetisolutions.smartcalc.entities.Utilisateur;
import java.util.Optional;
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
public class UtilisateurService {
    
    @Autowired
    private IUtilisateurDao utilisateurDao;
    
    public Utilisateur create(Utilisateur u){
        return utilisateurDao.save(u);
    }
    
    public Utilisateur findOneById(Long id){
        Optional<Utilisateur> optUser = utilisateurDao.findById(id);
        if(optUser != null){
            return optUser.get();
        }
        
        return null;
    }
    
    public Utilisateur update(Utilisateur u){
        return utilisateurDao.save(u);
    }
    
    public Page<Utilisateur> findAll(int from, int to){
        return utilisateurDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "id")));
    }
    
    public void delete(long id){
        utilisateurDao.deleteById(id);
    }
    
}
