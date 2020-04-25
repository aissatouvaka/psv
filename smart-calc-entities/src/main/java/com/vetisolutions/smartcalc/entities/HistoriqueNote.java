/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class HistoriqueNote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private Double lastValue;
    
    @Column
    private Date modifiactionDate;
    
    @Column
    private Long userId;
    
    @ManyToOne
    private Note note;
    
}
