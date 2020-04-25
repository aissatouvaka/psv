/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vetisolutions.smartcalc.entities.enumeration.Gender;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Eleve {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String firstname;
    
    @Column
    private String lastename;
    
    @Column
    private Gender gender;
    
    @Column
    private Date birthDate;
    
    @Column
    private String birthPlace;
    
    @Column
    private String fatherName;
    
    @Column
    private String motherName;
    
    @Column
    private String tutorName;
    
    //Matricule
    @Column
    private String registerNumber;
    
    @Column
    private Gender sex;
    
    @OneToMany(mappedBy = "eleve")
    @JsonIgnore
    private List<AbsenceEleve> absenceEleves;
    
}
