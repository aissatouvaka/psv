/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vetisolutions.smartcalc.entities.enumeration.Gender;
import com.vetisolutions.smartcalc.entities.enumeration.Role;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
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
@Inheritance(strategy = InheritanceType .JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String firstName;
    
    @Column
    private String lastName;
    
    @Column
    private Gender gender;
    
    @Column
    private String birthDay;
    
    @Column
    private String identityPiece;
    
    @Column
    private String login;
    
    @Column
    private String password;
    
    @Column
    private String email;
    
    @Column
    private String phone1;
    
    @Column
    private String phone2;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @ManyToOne
    private Ecole ecole;
    
}
