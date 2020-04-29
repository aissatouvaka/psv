/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities;

import java.io.Serializable;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Nappster-SPRINT-PAY
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Ecole implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    private String code;
    
    @Column
    private String name;
    
    @Column
    private String leftHeader;
    
    @Column
    private String rightHeader;
    
    @Column
    private String town;
    
    @Column
    private String phone1;
    
    @Column
    private String phone2;
    
    @Column
    private String email1;
    
    @Column
    private String email2;
    
    @Column
    private String website;
    
    @Column
    private String adress;
    
    @ManyToOne
    private TypeEtablissement typeEtablissement;
    
    //@OneToMany(mappedBy = "ecole")
    //private List<AnneeScolaire> anneeScolaires;
    
    //@OneToMany(mappedBy = "ecole")
    //private List<Utilisateur> utilisateurs;
    
}
