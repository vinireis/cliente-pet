package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.clientepet.pet.domain.Pet;

public interface PetSpringDataJPARepository extends JpaRepository<Pet, UUID> {
	List<Pet> findByIdClienteTutor(UUID idClienteTutor);
}
