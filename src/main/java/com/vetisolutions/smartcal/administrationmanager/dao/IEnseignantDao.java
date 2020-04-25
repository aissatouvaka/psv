package com.vetisolutions.smartcal.administrationmanager.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.vetisolutions.smartcalc.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vaka
 */
@Repository
public interface IEnseignantDao extends JpaRepository<Enseignant, Long>{
    
}
