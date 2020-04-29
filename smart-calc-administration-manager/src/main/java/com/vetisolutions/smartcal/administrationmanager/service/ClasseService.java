/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.service;

import com.vetisolutions.smartcal.administrationmanager.dao.IClasseDao;
import com.vetisolutions.smartcal.administrationmanager.dao.IEcoleDao;
import com.vetisolutions.smartcal.administrationmanager.dao.IEnseignantDao;
import com.vetisolutions.smartcalc.entities.Classe;
import com.vetisolutions.smartcalc.entities.Ecole;
import com.vetisolutions.smartcalc.entities.Enseignant;
import com.vetisolutions.smartcalc.entities.dto.ClasseDTO;
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
public class ClasseService {
    
    @Autowired
    private IClasseDao classeDao;
    
    @Autowired
    private IEnseignantDao ensDao;
    
    @Autowired
    private IEcoleDao ecoleDao;
    
    public Classe create(ClasseDTO cl){
        Classe classe = new Classe();
        classe.setTitle(cl.getTitle());
        classe.setName(cl.getName());
        classe.setSpeciality(cl.getSpeciality());
        classe.setLevel(cl.getLevel());
        Ecole ecl = ecoleDao.findById(cl.getEcoleId()).get();
        Enseignant ens = ensDao.findById(cl.getEnseignantId()).get();
        if(ecl != null && ens != null){
            classe.setEcole(ecl);
            classe.setPrincipal(ens);
            return classeDao.save(classe);
        }
        else{
            return null;
        }
    }
    
    public Classe findOneById(Long id){
        Optional<Classe> optClasse = classeDao.findById(id);
        if(optClasse != null){
            return optClasse.get();
        }
        
        return null;
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
