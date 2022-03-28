package br.edu.infnet.venturaHRWeb.app;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.venturaHRWeb.domain.Usuario;

@FeignClient(url = "http://localhost:8080/usuarios", name= "Usuarios")
public interface UsuarioService {
	@GetMapping(path = {"/email/{email}"})
	Usuario obterPorEmail (@PathVariable String email);
	@PostMapping
	Usuario inserirUsuario(Usuario usuario);
	
	
	@GetMapping()
	public List<Usuario>listarUsuarios();

	@GetMapping(path = {"/{id}"})
	public Usuario obterPorId(@PathVariable int id);
	
	@GetMapping(path = "/delete/{id}")
	public void deletarUsuario(@PathVariable int id);
}
