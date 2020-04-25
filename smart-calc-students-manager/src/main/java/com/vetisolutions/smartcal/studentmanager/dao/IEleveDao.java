/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcal.studentmanager.dao;

import com.vetisolutions.smartcalc.entities.Eleve;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vaka
 */

@Repository
public interface IEleveDao extends JpaRepository<Eleve, Long>{
    
    /**
     * retourne les élèves ayant pour date de naissance précisé
     * @param birthDate date de naissance recherché
     * @param page objet page
     * @return un objet eleve
     */
    
    public Page<Eleve> findByBirthDate(Date birthDate, Pageable page);
    
    /**
     * retourne l'élève ayant pour lieu de naissance précisé
     * @param birthPlace lieu de naissance recherché
     * @param page objet page
     * @return un objet eleve
     */
    
    public Page<Eleve> findByBirthPlace(String birthPlace, Pageable page);
    
    /**
     * retourne les élèves ayant pour nom de tuteur précisé
     * @param tutorName le nom du tuteur recherché
     * @param page objet page
     * @return un objet eleve
     */
    
    public Page<Eleve> findByTutorName(String tutorName, Pageable page);
    
    /**
     * retourne l'eleve ayant pour numéro de registre précisé
     * @param registerNumber le numéro de registre recherché
     * @return un objet eleve
     */
    
    public Eleve findByRegisterNumber(String registerNumber);
    
     /**
     * retourne les élèves ayant pour lieu et date de naissance précisé incluant la pagination
     * @param birthDate date de naissance de l'élève
     * @param birthPlace lieu de naissance de l'élève
     * @param page objet page
     * @return une page d'étudiants
     */
    public Page<Eleve> findByBirthDateAndBirthPlace( Date birthDate, String birthPlace, Pageable page);
    
    
}
