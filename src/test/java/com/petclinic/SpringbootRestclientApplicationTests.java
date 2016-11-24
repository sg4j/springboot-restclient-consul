package com.petclinic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.petclinic.util.PetClinicPetUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootRestclientApplication.class)
@WebAppConfiguration
public class SpringbootRestclientApplicationTests {

	@Autowired
	private PetClinicPetUtil petUtil;
	
	@Test
	public void contextLoads() {
		
		//petUtil.getPetById(2);
	}

}
