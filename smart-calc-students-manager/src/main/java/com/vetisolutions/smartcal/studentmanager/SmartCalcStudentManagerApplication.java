package com.vetisolutions.smartcal.studentmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan("com.vetisolutions.smartcalc.entities")
@ComponentScan(basePackages = "com.vetisolutions.smartcal.studentmanager")
@SpringBootApplication
@EnableSwagger2
public class SmartCalcStudentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartCalcStudentManagerApplication.class, args);
	}

}
