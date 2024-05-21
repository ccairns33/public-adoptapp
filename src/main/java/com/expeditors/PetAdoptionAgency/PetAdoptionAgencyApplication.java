package com.expeditors.PetAdoptionAgency;

import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import com.expeditors.PetAdoptionAgency.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@SpringBootApplication
public class PetAdoptionAgencyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PetAdoptionAgencyApplication.class, args);
	}
//	private AdopterService adopterService;
//
//	public PetAdoptionAgencyApplication(AdopterService adopterService) {
//		this.adopterService = adopterService;
//	}




	@Override
	public void run(String... args) throws Exception {
//		List <Pet> joeyPets = new ArrayList<>() ;
//		joeyPets.add(Pet.builder().name("Jefferson").type(Pet.PetType.DOG).breed("Rottweiler").build());
//		joeyPets.add(Pet.builder().name("jocky").breed("dalmation").type(Pet.PetType.DOG).build());
//
//		List <Pet> franniePets = new ArrayList<>();
//		franniePets.add(Pet.builder().type(Pet.PetType.DOG).name("Freya").breed("Mutt").build());
//		franniePets.add(Pet.builder().type(Pet.PetType.DOG).name("French").breed("French Bulldog").build());
//
//		List <Pet> darlenePets = new ArrayList<>();
//		darlenePets.add(Pet.builder().type(Pet.PetType.CAT).name("Danica").breed("Mutt").build());
//
//		List <Pet> miguelPets = new ArrayList<>();
//		miguelPets.add(Pet.builder().type(Pet.PetType.TURTLE).name("toruga").breed("American Red").build());


//		var adopters = List.of(
//				new Adopter("Cmd-Joey", "383 9999 9393", LocalDate.of(1960, 6, 9),
//						joeyPets),
//				new Adopter("Cmd-Francine", "383 9339 9999 9393", LocalDate.parse("2020-05-09"),
//						franniePets),
//				new Adopter("Cmd-Darlene", "44484 9339 77939", LocalDate.parse("2020-05-09"),
//						darlenePets),
//				new Adopter("Cmd-Miguel", "77 888 93938", LocalDate.parse("2022-03-09"),
//						miguelPets)
//		);
//		adopters.forEach(adopterService::addAdopter);
//
//		List<Adopter> result = adopterService.getAllAdopters();
//		out.println("result: " + result.size());
//		result.forEach(out::println);

	}
}
