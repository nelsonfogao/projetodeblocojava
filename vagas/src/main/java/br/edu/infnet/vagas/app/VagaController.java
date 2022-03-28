package br.edu.infnet.vagas.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.vagas.domain.Criterio;
import br.edu.infnet.vagas.domain.Vaga;


@RestController
@RequestMapping(path = {"/vagas"})
public class VagaController {
	
	@Autowired
	private VagaService vagaService;

	@GetMapping(path = "/usuario/{idUsuario}")
	public ResponseEntity<Object> listarPorIdUsuario(@PathVariable int idUsuario) {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			List<Vaga> lista = vagaService.findByIdUsuario(idUsuario);
			if(!lista.isEmpty()) {
				retorno = ResponseEntity.ok().body(lista);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@GetMapping(path = "/cargo/{pesquisa}")
	public ResponseEntity<Object> pesquisarVagasPorCargo(@PathVariable String pesquisa) {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			List<Vaga> lista = vagaService.findByCargoContainingIgnoreCase(pesquisa);
			if(!lista.isEmpty()) {
				retorno = ResponseEntity.ok().body(lista);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@GetMapping(path = "/cidade/{pesquisa}")
	public ResponseEntity<Object> pesquisarVagasPorCidade(@PathVariable String pesquisa) {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			List<Vaga> lista = vagaService.findByCidadeContainingIgnoreCase(pesquisa);
			if(!lista.isEmpty()) {
				retorno = ResponseEntity.ok().body(lista);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@PostMapping
	public ResponseEntity<Object> publicarVaga(@RequestBody Vaga vaga) {
		ResponseEntity<Object> retorno = ResponseEntity.badRequest().build();
		
		List<Criterio> listaCriterio = vaga.getCriterioList();
		if(listaCriterio != null && !listaCriterio.isEmpty()) {
			for(Criterio criterio : listaCriterio) {
				criterio.setVaga(vaga);
			}
			Vaga gravado = vagaService.publicarVaga(vaga);
			retorno = ResponseEntity.status(201).body(gravado);
		}
		return retorno;
	}
	
	@GetMapping()
	public ResponseEntity<Object> listarVagas() {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			List<Vaga> lista = vagaService.obterLista();
			if(!lista.isEmpty()) {
				retorno = ResponseEntity.ok().body(lista);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable int id) {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			Vaga vaga = vagaService.findById(id);
				retorno = ResponseEntity.ok().body(vaga);
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@GetMapping("/delete/{id}")
	public void deletarVaga(@PathVariable int id) {
		Vaga vagaDeletada = vagaService.findById(id);
		if(vagaDeletada != null) {
			try {
				 vagaService.excluir(id);
			}catch(Exception e) {
			}
		}
	}

}
