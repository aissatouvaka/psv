/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.administrationmanager.dao;

import com.vetisolutions.smartcalc.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vaka
 */
@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long>{
    
}
