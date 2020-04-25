/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities.dto;

import com.vetisolutions.smartcalc.entities.TypeClasse;
import lombok.Data;

/**
 *
 * @author vaka
 */

@Data
public class ClasseDTO {
    
    private Long id;
    
    private String name;
    
    private String title;
    
    private Long level;
    
    private String speciality;
    
    private Long ecoleId;
    
    private Long enseignantId;
    
}
