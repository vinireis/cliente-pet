package br.com.petz.clientepet.pet.infra;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.pet.application.service.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJPARepository;
	
	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[start] PetInfraRepository - salvaPet");
		petSpringDataJPARepository.save(pet);
		log.info("[finish] PetInfraRepository - salvaPet");
		return pet;
	}
}