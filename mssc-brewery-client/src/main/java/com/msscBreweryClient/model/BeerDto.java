package com.msscBreweryClient.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // creates getters & setters, equals and hashCodes at compile time
@NoArgsConstructor
@AllArgsConstructor
@Builder //builder pattern for lombok at compile time
public class BeerDto {
	private UUID id;
	//private Integer version;
	
	//private OffsetDateTime createdDate;
	//private OffsetDateTime lastModifiedDate;
	private String beerName;
	private String beerStyle;
	private Long upc;
	
	//private BigDecimal price;
	
	//private Integer quantityOnHand;
}
