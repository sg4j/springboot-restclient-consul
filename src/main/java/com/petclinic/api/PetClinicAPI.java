package com.petclinic.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.util.PetClinicUtil;

@RestController
public class PetClinicAPI {

	@Autowired        // Created automatically by Spring Cloud
	private PetClinicUtil petClinicPetUtil;
    
	@RequestMapping("/pet/id")
	public String getPetById(@RequestParam(value="id") Integer id){
		
        String pet = petClinicPetUtil.getPetById(id);
        
		return(pet);
		
	}
}
