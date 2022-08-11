package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Getter;

@Getter
public class PetClienteListResponse {
	private UUID idPet;
	private String nomePet;
	private TipoPet tipo;
	private String raca;
	private String pelagemCor;
	private LocalDate dataNascimento;

	public static List<PetClienteListResponse> converte(List<Pet> petsDoCliente) {
		return petsDoCliente.stream()
				.map(PetClienteListResponse::new)
				.collect(Collectors.toList());
	}

	public PetClienteListResponse(Pet pet) {
		this.idPet = pet.getIdPet();
		this.nomePet = pet.getNomePet();
		this.tipo = pet.getTipo();
		this.raca = pet.getRaca();
		this.pelagemCor = pet.getPelagemCor();
		this.dataNascimento = pet.getDataNascimento();
	}
}
