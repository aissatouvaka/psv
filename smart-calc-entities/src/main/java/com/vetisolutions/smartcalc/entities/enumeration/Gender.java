/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetisolutions.smartcalc.entities.enumeration;

/**
 *
 * @author Nappster-SPRINT-PAY
 */
public enum Gender {
    
    MALE("MALE"), FEMALE("FEMALE");
    
    private String name;
    
    private Gender(String name){
        this.name = name;
    }
    
}
