/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities;

import javax.persistence.Entity;
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
public class AbsenceEleve extends AbstractWeekCounteur{
    
    @ManyToOne(optional = false)
    private Eleve eleve;
    
}
