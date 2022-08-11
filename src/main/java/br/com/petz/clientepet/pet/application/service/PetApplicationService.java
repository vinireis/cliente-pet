package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalheResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRepository petRepository;

	@Override
	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] PetApplicationService - criaPet");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finish] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<PetClienteListResponse> buscaPetsDoClienteComID(UUID idCliente) {
		log.info("[start] PetApplicationService - buscaPetsDoClienteComID");
		clienteService.buscaClienteAtravesId(idCliente);
		List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComID(idCliente);
		log.info("[finish] PetApplicationService - buscaPetsDoClienteComID");
		return PetClienteListResponse.converte(petsDoCliente);
	}

	@Override
	public PetClienteDetalheResponse buscaPetDoClienteComID(UUID idCliente, UUID idPet) {
		log.info("[start] PetApplicationService - buscaPetDoClienteComID");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		log.info("[finish] PetApplicationService - buscaPetDoClienteComID");
		return new PetClienteDetalheResponse(pet);
	}

	@Override
	public void deletaPetDoClienteComID(UUID idCliente, UUID idPet) {
		log.info("[start] PetApplicationService - deletaPetDoClienteComID");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		petRepository.deletaPet(pet);
		log.info("[finish] PetApplicationService - deletaPetDoClienteComID");
	}
}
