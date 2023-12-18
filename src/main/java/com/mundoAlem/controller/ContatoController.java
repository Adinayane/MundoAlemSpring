package com.mundoAlem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mundoAlem.model.Contato;
import com.mundoAlem.repository.ContatoRepository;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoRepository contRepo;
	
	@GetMapping("/listaMensagens")
	public ModelAndView listmensagem() {
		ModelAndView modelandview = new ModelAndView("contato/listarMensagens.html");
		
		List<Contato> contatos = contRepo.findAll();
		modelandview.addObject("contato", contatos);
		return modelandview;
	}
	
	@GetMapping("/enviar-mensagem")
	public ModelAndView cadastrar() {
		ModelAndView modandView = new ModelAndView("pages/contato.html");
		modandView.addObject("contato", new Contato());
		
		return modandView;
	}
	
	@PostMapping("/enviar-mensagem")
	public ModelAndView salvar(Contato contato) {
		ModelAndView modelandview = new ModelAndView("redirect:/");
		contRepo.save(contato);
		return modelandview;
	}
	
	@GetMapping("/{id}/excluir-mensagem")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("redirect:/contato/listaMensagens");
		contRepo.deleteById(id);
		return modelandview;
	}
	
	@GetMapping("/contato/{id}")
	public ModelAndView detalhar(@PathVariable Long id, Model model) {
		ModelAndView modelandview = new ModelAndView("contato/detalharMensagens.html");
		Contato contato = contRepo.getReferenceById(id);
		
		if(contato != null && !contato.isLido()) {
			contato.setLido(true);
			contRepo.save(contato);
		}
		
		modelandview.addObject("contato", contato);
		return modelandview;
	}
}
