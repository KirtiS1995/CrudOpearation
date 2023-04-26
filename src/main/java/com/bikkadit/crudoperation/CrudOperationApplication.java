package com.bikkadit.crudoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bikkadit.crudoperation.entity.User;

@SpringBootApplication
public class CrudOperationApplication {

	public static void main(String[] args) {
	SpringApplication.run(CrudOperationApplication.class, args);
		
		System.out.println("CRUD operation ");
		
//		User u= new User();
//		u.setUserEmail(null);
				
	}

}
