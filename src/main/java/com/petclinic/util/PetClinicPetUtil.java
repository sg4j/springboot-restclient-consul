package com.petclinic.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Component
public class PetClinicPetUtil implements PetClinicUtil {

	@Autowired  
	private LoadBalancerClient loadBalancerClient;
	
    protected RestTemplate restTemplate = new RestTemplate(); 
    
    @HystrixCommand(fallbackMethod="generalPetInfo")
	public String getPetById(@RequestParam(value="id") Integer id){
		
		ServiceInstance instance = loadBalancerClient.choose("petclinic-ignite");
		
		System.out.println("Came here in PetClinicPetUtil.getPetById with service URL "+instance.getUri().toString());
		
        String pet = restTemplate.getForObject(instance.getUri().toString()+ "/petclinic/pet/id?id={id}", String.class, id);
        
        System.out.println("Pet found is "+pet);
		return(pet);
		
	}
    
    public String generalPetInfo(Integer id){
    	return "This is a genral PET. Came here after Hystrix Circuit opened.";
    }
}
