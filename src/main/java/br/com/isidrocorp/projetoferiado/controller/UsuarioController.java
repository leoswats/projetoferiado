package br.com.isidrocorp.projetoferiado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetoferiado.dao.UsuarioDAO;
import br.com.isidrocorp.projetoferiado.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario dadosUserLogin) {
		Usuario resultado = dao.findByRacfOrFuncional(dadosUserLogin.getRacf(), dadosUserLogin.getFuncional());
		if (resultado != null) {  // encontrou!!
			if (resultado.getSenha().equals(dadosUserLogin.getSenha())) { // senhas conferem???
 				resultado.setSenha("*************");
				return ResponseEntity.ok(resultado);
			}
			else {
				return ResponseEntity.status(401).build(); // senha não confere, portanto retorna 401
			}
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	

}
