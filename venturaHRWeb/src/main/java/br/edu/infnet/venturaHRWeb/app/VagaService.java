package br.edu.infnet.venturaHRWeb.app;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.venturaHRWeb.domain.Vaga;

@FeignClient(url = "http://localhost:8082/vagas", name= "Vagas")
public interface VagaService {
	@GetMapping(path = "/usuario/{idUsuario}")
	public List<Vaga> listarPorIdUsuario(@PathVariable int idUsuario);
	
	@GetMapping()
	public List<Vaga>listarVagas();
	
	@PostMapping
	public Vaga publicarVaga(Vaga vaga);
	
	@GetMapping(path = {"/{id}"})
	public Vaga obterPorId(@PathVariable int id);
	
	@GetMapping(path = "/delete/{id}")
	public void deletarVaga(@PathVariable int id);
}
