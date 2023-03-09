package com.arcesi.gestionusers;

import java.net.Inet4Address;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.arcesi.gestionusers.entities.RoleBean;
import com.arcesi.gestionusers.entities.UserBean;
import com.arcesi.gestionusers.enumerations.RoleEnemuration;
import com.arcesi.gestionusers.repositories.RoleRepository;
import com.arcesi.gestionusers.repositories.UserRepository;

@SpringBootApplication
public class GestionDesUtilisateursApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesUtilisateursApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserRepository userRepository,RoleRepository roleRepository) {
		return args->{
			//Employe  
			RoleBean roleEmploye=RoleBean.builder()
					                  .codeUniqueRole(UUID.randomUUID().toString().replace("-", ""))
					                  .createdAt(Instant.now())
					                  .updatedAd(Instant.now())
					                  .roleName(RoleEnemuration.EMP.getLabel())
					                  .build();
                    
			  //Client  
			  RoleBean roleClient=RoleBean.builder()
			    		.codeUniqueRole(UUID.randomUUID().toString().replace("-", ""))
			    		.createdAt(Instant.now())
			    		.updatedAd(Instant.now())
			    		.roleName(RoleEnemuration.CLT.getLabel())
			    		.build();
			    
			    RoleBean roleAdmin=RoleBean.builder()
			    		.createdAt(Instant.now())
			    		.updatedAd(Instant.now())
			    		.codeUniqueRole(UUID.randomUUID().toString().replace("-","" ))
			    		.roleName(RoleEnemuration.ADMIN.getLabel())
			    		.build();
			    
			    //save all roles
			    roleRepository.saveAll(Arrays.asList(roleClient,roleEmploye,roleAdmin));
			    
			    
			    //Creation des utilisateurs
			    for(int i=0;i<6;i++) {
			    	RoleBean roleBean=roleRepository.findById(1L).get();
			    	
			    	UserBean userBean=UserBean.builder()
			    			.createdAt(Instant.now())
			    			.updatedAd(Instant.now())
			    			.uidUser(UUID.randomUUID().toString().replace("-", ""))
			    			.firstName("tibari"+i)
			    			.lastName("zeroual"+i)
			    			.email("tibarinewdzign"+i+"@gmail.com")
			    			.enabled(new Random().nextBoolean())
			    			.locked(new Random().nextBoolean())
			    			.ipAdresse(Inet4Address.getLocalHost().getHostAddress())
			    			.password("boudarga")
			    			.build();
			    	UserBean userSaved= userRepository.save(userBean);
			    	userSaved.getRoleBeans().add(roleClient);
			    	userRepository.saveAndFlush(userSaved);
			    	
			    }
			    
		};
	}
}
