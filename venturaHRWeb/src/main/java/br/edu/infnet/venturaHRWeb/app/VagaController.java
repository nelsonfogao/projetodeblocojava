package br.edu.infnet.venturaHRWeb.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.venturaHRWeb.domain.Usuario;
import br.edu.infnet.venturaHRWeb.domain.Vaga;


@Controller
public class VagaController {
	@Autowired
	private VagaService vagaService;
	
	@GetMapping(path = "/vagas")
	public String telaLista(Model model) {

		model.addAttribute("vagaLista", vagaService.listarVagas());
		
		return "vaga/lista";
	}
	
	@PostMapping(value = "/vaga/incluir")
	public String incluir(Vaga vaga, @SessionAttribute("user") Usuario usuario) {

		vaga.setIdUsuario(usuario.getId());
		vagaService.publicarVaga(vaga);
		
		return "redirect:/vagas";
	}
	
	@GetMapping(value = "/vaga")
	public String telaCadastro() {
		return "vaga/cadastro";
	}
	
	@GetMapping(value = "/vaga/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		Vaga vaga = vagaService.obterPorId(id);

		if(vaga != null) {			
			vagaService.deletarVaga(id);
			
			model.addAttribute("mensagem", "A vaga "+vaga.getCargo()+" foi excluída com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Vaga inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model);
	}
}
