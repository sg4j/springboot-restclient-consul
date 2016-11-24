package com.petclinic.util;

import org.springframework.stereotype.Service;

@Service
public interface PetClinicUtil{

	public String getPetById(Integer id);
}
