package br.edu.infnet.vagas.app;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.vagas.domain.Vaga;
import br.edu.infnet.vagas.infra.VagaRepository;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	List<Vaga> findByIdUsuario(Integer idUsuario){
		return vagaRepository.findByIdUsuario(idUsuario);
	}
	
	List<Vaga> findByCargoContainingIgnoreCase(String pesquisa){
		return vagaRepository.findByCargoContainingIgnoreCase(pesquisa);
	}
	
	List<Vaga> findByCidadeContainingIgnoreCase(String pesquisa){
		return vagaRepository.findByCidadeContainingIgnoreCase(pesquisa);
	}
	
	public Vaga publicarVaga(Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	public List<Vaga> obterLista() {
		return (List<Vaga>) vagaRepository.findAll(); 
	}
	public Vaga findById(Integer id) {
		return vagaRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		vagaRepository.deleteById(id);
	}
}
