package br.edu.infnet.app;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.domain.Usuario;
import br.edu.infnet.infra.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario autenticacao(String email, String senha) {
		return usuarioRepository.autenticacao(email, senha);
	}
	public List<Usuario> obterLista(){		
		return (List<Usuario>) usuarioRepository.findAll();
	}	
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	
	
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}