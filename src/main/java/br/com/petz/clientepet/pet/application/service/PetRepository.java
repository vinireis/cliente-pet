package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.domain.Pet;

public interface PetRepository {
	Pet salvaPet(Pet pet);
	List<Pet> buscaPetsDoClienteComID(UUID idCliente);
	Pet buscaPetPeloId(UUID idPet);
}
