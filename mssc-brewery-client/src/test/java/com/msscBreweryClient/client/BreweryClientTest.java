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
		if (uri.toString()== null) {
			System.out.println("http://localhost:8080/api/v1/beer-service/" + beerDto.getId());
			
		} else {
			assertNotNull(uri);
		}

		// System.out.println("Printing URi in testCase2 ====> "+uri.toString());
	}

}
