package com.mundoAlem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mundoAlem.enums.UF;
import com.mundoAlem.model.Usuario;
import com.mundoAlem.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@GetMapping("/listar-usuario")
	public ModelAndView listauser() {
		ModelAndView modelandview = new ModelAndView("usuario/listarUsuario.html");
		
		List<Usuario> usuarios = userRepo.findAll();
		modelandview.addObject("usuario", usuarios);
		return modelandview;
	}
	
	@GetMapping("/cadastrar-usuario")
	public ModelAndView cadastrar() {
		ModelAndView modandView = new ModelAndView("usuario/formCadastroUsuario.html");
		modandView.addObject("usuario", new Usuario());
		modandView.addObject("uf", UF.values());
		
		return modandView;
	}
	
	@PostMapping("/cadastro-usuario")
	public ModelAndView salvar(Usuario usuario) {
		ModelAndView modelandview = new ModelAndView("redirect:/usuario/listar-usuario");
		userRepo.save(usuario);
		return modelandview;
	}
	
	@GetMapping("/{id}/editar-usuario")
	public ModelAndView editarUsuario(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("usuario/editarUsuario.html");
		Usuario user = userRepo.getReferenceById(id);
		modelandview.addObject("usuario", user);
		modelandview.addObject("uf", UF.values());
		
		return modelandview;
	}
	
	@PostMapping("/{id}/editar-usuario")
	public ModelAndView editar(Usuario usuario) {
		userRepo.save(usuario);
		ModelAndView modelandview = new ModelAndView("redirect:/usuario/listar-usuario");
		return modelandview;
	}
	
	@GetMapping("/{id}/excluir-usuario")
	public ModelAndView excluirUsuario(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("redirect:/usuario/listar-usuario");
		userRepo.deleteById(id);
		return modelandview;
	}
	
	@GetMapping("/usuario/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("usuario/detalharUsuario.html");
		Usuario usuario = userRepo.getReferenceById(id);
		modelandview.addObject("usuario", usuario);
		return modelandview;
	}
}
