package com.msscBreweryClient.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.msscBreweryClient.model.BeerDto;

@SpringBootTest
class BreweryClientTest {

	@Autowired
	BreweryClient client;

	@Test
	void testGetBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		// fail("Not yet implemented");
		assertNotNull(dto);
	}

	@Test
	void testSaveNewBeer() {
		BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer Set").beerStyle("Strong").upc(12L)
				.build();
		URI uri = client.saveNewBeer(beerDto);
		System.out.println("Printing beerDto ====> " + beerDto);
		System.out.println("Printing URI path ====> " + uri.getPath());		
		assertNotNull(uri);	
		// System.out.println("Printing URi in testCase2 ====> "+uri.toString());
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("Updated BeerName").build();
		client.updateBeer(UUID.randomUUID(), beerDto);
	}

}
