package br.edu.infnet.vagas.infra;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.vagas.domain.Vaga;

public interface VagaRepository extends CrudRepository<Vaga, Integer>{
	
	List<Vaga> findByIdUsuario(Integer idUsuario);
	
	List<Vaga> findByCargoContainingIgnoreCase(String pesquisa);
	
	List<Vaga> findByCidadeContainingIgnoreCase(String pesquisa);
}
