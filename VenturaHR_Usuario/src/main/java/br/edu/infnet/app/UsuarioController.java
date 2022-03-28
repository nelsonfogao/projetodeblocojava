package br.edu.infnet.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.domain.Usuario;

@RestController
@RequestMapping(path = {"/usuarios"})
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Object> obterPorId(@PathVariable int id) {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			Usuario usuario = usuarioService.findById(id);
			if(usuario != null) {
				retorno = ResponseEntity.ok().body(usuario);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@GetMapping(path = {"/email/{email}"})
	public ResponseEntity<Object> obterPorEmail(@PathVariable String email) {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		try {
			Usuario usuario = usuarioService.findByEmail(email);
			if(usuario != null) {
				retorno = ResponseEntity.ok().body(usuario);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@PostMapping
	public ResponseEntity<Object> inserirUsuario(@RequestBody Usuario usuario) {
		ResponseEntity<Object> retorno = ResponseEntity.badRequest().build();
		
		if(usuario != null && usuario.getId() == null) {
			Usuario usuarioInserido = usuarioService.inserirUsuario(usuario);
			retorno = ResponseEntity.status(201).body(usuarioInserido);
		}
		return retorno;
	}
	
	@PutMapping
	public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario) {
		ResponseEntity<Object> retorno = ResponseEntity.badRequest().build();
		
		if(usuario != null && usuario.getId() == null) {
			Usuario usuarioGravado = usuarioService.findById(usuario.getId());
			if(usuarioGravado != null) {
				try {
					usuarioGravado = usuarioService.inserirUsuario(usuario);
					retorno = ResponseEntity.ok().body(usuarioGravado);
				}catch(Exception e) {
				}
			}
		}
		return retorno;
	}
	
	@GetMapping()
	public ResponseEntity<Object> listarUsuarios() {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			List<Usuario> lista = usuarioService.obterLista();
			if(!lista.isEmpty()) {
				retorno = ResponseEntity.ok().body(lista);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@GetMapping("/delete/{id}")
	public void deletarUsuario(@PathVariable int id) {
		Usuario usuarioDeletado = usuarioService.findById(id);
		if(usuarioDeletado != null) {
			try {
				 usuarioService.excluir(id);
			}catch(Exception e) {
			}
		}
	}
}
