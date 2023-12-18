package com.mundoAlem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mundoAlem.enums.tipoDestino;
import com.mundoAlem.model.Destino;
import com.mundoAlem.repository.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoRepository destRepository;
	
	@GetMapping("/listar-destino")
	public ModelAndView listarDestino() {
		ModelAndView modelandview = new ModelAndView("destino/listaDestino.html");
		
		List<Destino> destinos = destRepository.findAll();
		modelandview.addObject("destino", destinos);
		return modelandview;
	}
	
	@GetMapping("/cadastrar-destino")
	public ModelAndView cadastrarDestino() {
		ModelAndView modelandview = new ModelAndView("destino/cadastrarDestino.html");
		modelandview.addObject("destino", new Destino());
		modelandview.addObject("tipo", tipoDestino.values());
		return modelandview;
	}
	
	@PostMapping("/cadastrar-destino")
	public ModelAndView cadastraDestino(Destino destino) {
		ModelAndView modelandview = new ModelAndView("redirect:/destino/listar-destino");
		destRepository.save(destino);
		return modelandview;
	}
	
	@GetMapping("/{id}/editar-destino")
	public ModelAndView editarDestino(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("destino/editarDestino.html");
		Destino dest = destRepository.getReferenceById(id);
		modelandview.addObject("destino", dest);
		modelandview.addObject("tipo", tipoDestino.values());
		return modelandview;
	}
	
	@PostMapping("/{id}/editar-destino")
	public ModelAndView editar(Destino destino) {
		destRepository.save(destino);
		ModelAndView modelandview = new ModelAndView("redirect:/destino/listar-destino");
		return modelandview;
	}
	
	@GetMapping("/{id}/excluir-destino")
	public ModelAndView excluirDestino(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("redirect:/destino/listar-destino");
		destRepository.deleteById(id);
		return mav;
	}
	
	@GetMapping("/destino/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("destino/detalharDestino.html");
		Destino dest = destRepository.getReferenceById(id);
		mav.addObject("destino", dest);
		return mav;
	}
	
}
