package br.edu.infnet.venturaHRWeb.app;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.venturaHRWeb.domain.Usuario;

@SessionAttributes("user")
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/")
	public String telaHome() {
		return "home";		
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";		
	}

	@GetMapping(value = "/logout")
	public String logout(SessionStatus status, HttpSession session) {
		
		status.setComplete();
		session.removeAttribute("user");
		
		return "redirect:/";		
	}

	@PostMapping(value = "/login")
	public String validar(Model model, @RequestParam String email){
		
		Usuario usuario = usuarioService.obterPorEmail(email);

		if(usuario != null) {
			model.addAttribute("user", usuario);
			
			return "redirect:/";
		} else {
			model.addAttribute(
					"mensagem", 
					"As credenciais do usuário "+ email +" estão incorretas!!!"
				);

			return telaLogin();
		}	

	}
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuarios")
	public String telaLista(Model model) {

		model.addAttribute("usuarioLista", usuarioService.listarUsuarios());

		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario){

		usuarioService.inserirUsuario(usuario);

		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		Usuario usuario = usuarioService.obterPorId(id);

		if(usuario != null) {			
			usuarioService.deletarUsuario(id);
			
			model.addAttribute("mensagem", "O usuário "+usuario.getNome()+" foi excluído com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Usuário inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model);
	}
}
