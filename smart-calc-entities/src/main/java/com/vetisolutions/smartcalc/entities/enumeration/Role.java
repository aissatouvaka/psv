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
public enum Role {
    
    SUPER_ADMIN("SUPER_ADMIN"),
	
    ADMIN("ADMIN"),
	
    ENSEIGNANT("ENSEIGNANT"),
	
    PERSONNEL_APPUIT("PERSONNEL_APPUIT"),
    
    SURVEILLANT("SURVEILLANT"),
    
    CENSSEUR("CENSSEUR");
	
	
	private String name ;
	
	
	private Role(String name) {
		this.name = name ;
	}
    
}
