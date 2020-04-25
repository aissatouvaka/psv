package com.vetisolutions.smartcal.administrationmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan("com.vetisolutions.smartcalc.entities")
@SpringBootApplication   
@EnableSwagger2
public class SmartCalcAdministrationManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartCalcAdministrationManagerApplication.class, args);
	}

}
