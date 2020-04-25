/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.studentmanager.service;

import com.vetisolutions.smartcal.studentmanager.dao.IEleveDao;
import com.vetisolutions.smartcalc.entities.Eleve;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaka
 */

@Service
@Transactional
public class EleveService {
    
    @Autowired
    private IEleveDao eleveDao;
    
    public Eleve create(Eleve e){
        return eleveDao.save(e);
    }
    
    public Eleve update(Eleve e){
        return eleveDao.save(e);
    }
    
    public Page<Eleve> findAll(int from, int to){
        return eleveDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "id")));
    }
    
    public Page<Eleve> findAllByBirthDate(Date birthDate, int from, int to){
        return eleveDao.findByBirthDate(birthDate, PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "date")));
    }
    
    public Page<Eleve> findAllByBirthPlace(String birthPlace, int from, int to){
        return eleveDao.findByBirthPlace(birthPlace, PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "date")));
    }
    
    public Page<Eleve> findAllByTutorName(String tutorName, int from, int to){
        return eleveDao.findByTutorName(tutorName, PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "nom")));
    }
    
    public Eleve findOneByRegisterNumber(String registerNumber){
        return eleveDao.findByRegisterNumber(registerNumber);
    }
    
    public Page<Eleve> findAllByBirthDateAndBirthPlace(Date birthDate, String birthPlace, int from, int to){
        return eleveDao.findByBirthDateAndBirthPlace(birthDate, birthPlace, PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "date", "place")));
    }
    
    public void delete(long id){
        eleveDao.deleteById(id);
    }
}
