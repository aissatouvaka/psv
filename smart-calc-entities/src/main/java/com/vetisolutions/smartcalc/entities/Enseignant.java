/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Nappster-SPRINT-PAY
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Enseignant extends Utilisateur implements Serializable {
    
    @Column
    private String speciality;
    
    @OneToMany(mappedBy = "enseignant")
    private List<Cours> courses;
    
    @OneToMany(mappedBy = "enseignant")
    private List<EmpoieDeTemps> empoieDeTempses;
    
    @OneToMany(mappedBy = "enseignant")
    private List<PresenceEnseignant> presences;
    
}
