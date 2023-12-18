package com.mundoAlem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mundoAlem.servicos.VerificaLogin;

@Controller
@RequestMapping("/")
public class PagesController {
	
	@Autowired
	private VerificaLogin verificalogin;

	@GetMapping("/")
	public String inicio() {
		return "pages/inicio";
	}
	
	@GetMapping("/promocoes")
	public String promocoes() {
		return "pages/promocoes";
	}
	
	@GetMapping("/destinos")
	public String destino() {
		return "pages/destino";
	}
	
	/*@GetMapping("/contato")
	public String contato() {
		return "pages/contato";
	}*/
	
	@GetMapping("/opcoes")
	public String opcoes() {
		return "pages/selecao";
	}
	
	@GetMapping("/login")
	public String login() {
		return "pages/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
		if(verificalogin.autentica(email, password)) {
			return "redirect:/opcoes";
		}else {
			model.addAttribute("error", "Credenciais inválidas. Tente novamente.");
            return "redirect:/login";
		}
	}
	
	@GetMapping("/nao-disponivel")
	public String manutencao() {
		return "pages/manutencao";
	}
}
