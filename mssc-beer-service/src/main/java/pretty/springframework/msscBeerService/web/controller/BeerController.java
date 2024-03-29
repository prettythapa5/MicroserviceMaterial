package pretty.springframework.msscBeerService.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pretty.springframework.msscBeerService.web.model.BeerDto;

@RestController
@RequestMapping("/api/v1/beer-service")
public class BeerController {
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
		//TODO - impl
		return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto){
		//TODO impl
//		return new ResponseEntity<>(beerDto.builder().build(), HttpStatus.CREATED);
	return new ResponseEntity<BeerDto>(BeerDto.builder().build(), HttpStatus.CREATED);
	}
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> updateBeerById(@RequestBody BeerDto beerDto, 
												@PathVariable("beerId") UUID beerId){
		//TODO - impl
		return new ResponseEntity<BeerDto>(BeerDto.builder().build(), HttpStatus.NO_CONTENT);
	}
}
