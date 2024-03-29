package com.msscBreweryClient.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.msscBreweryClient.model.BeerDto;

@Controller // @Component can also be used...
//@Component
//@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false) 
// didn't add @ConfigPro.... was causing error.

public class BreweryClient {
	//http://localhost:8080/api/v1/beer-service/
	public final String BEER_PATH_V1 = "/api/v1/beer-brewery/";
	
	//when I used @Autowired there was qualifier exception for RestTemplate
	/*
	 * Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException:
	 * No qualifying bean of type 'org.springframework.web.client.RestTemplate'
	 * available: expected at least 1 bean which qualifies as autowire candidate.
	 * Dependency annotations:
	 * {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	 */
	
	//@Autowired
	private final RestTemplate restTemplate;
	
	@Value("${sfg.brewery.apihost}")
	private String apiHost;

	@Value("${spring.profiles.active}")
	String profile;

	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	} 
	
	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	public BeerDto getBeerById(UUID uuid) {
		System.out.println("Profile ===========================> "+profile);
		System.out.println("APi HOST ---------------"+apiHost);
		System.out.println("BEER_PATH_V1    "+BEER_PATH_V1);
		
		System.out.println("********>>>>>"+restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class));
		//System.out.println(restTemplate.exchange(apiHost + BEER_PATH_V1 + uuid.toString(), HttpMethod.GET, BeerDto.class);
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
	}
	
	public URI saveNewBeer(BeerDto beerDto) {
		System.out.println("print beerDto in client controller"+beerDto);
		System.out.println("Printing path in client controller ==>"+
				restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto));
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
	}

	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apiHost + BEER_PATH_V1 + uuid.toString(), beerDto);
		
	}
	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + uuid);
	}
}
