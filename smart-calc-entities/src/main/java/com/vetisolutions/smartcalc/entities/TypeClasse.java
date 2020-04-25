/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
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
@Entity//Hineritence to manage
@Inheritance(strategy = InheritanceType .JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeClasse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private Long level;
    
    @Column
    private String speciality;
    
    @OneToMany(mappedBy = "typeClasse")
    private List<Discipline> disciplines;
    
    @ManyToOne
    private Ecole ecole;
    
}
