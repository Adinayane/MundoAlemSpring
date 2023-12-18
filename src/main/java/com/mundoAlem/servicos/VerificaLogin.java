package com.mundoAlem.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundoAlem.model.Usuario;
import com.mundoAlem.repository.UsuarioRepository;

@Service
public class VerificaLogin {
	
	@Autowired
	private UsuarioRepository userRepo;
	
	public boolean autentica(String email, String password) {
		Optional<Usuario> opcao = userRepo.findByEmail(email);
		if(opcao.isPresent()) {
			Usuario user = opcao.get();
			return user.getSenha().equals(password);
		}
		return false;
	}
}
