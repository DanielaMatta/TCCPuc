package com.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usuario2Controller {
	
	
	@Autowired
	private Usuario2Service service;
	
	@PostMapping(value = "/api/user")
	public ResponseEntity<Usuario> postCustomer(@RequestBody Usuario user) {
		Usuario userReturn = null;
		try {
			service.findEmailByNomeAndSenha(user.getNome(), user.getSenha());
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			Usuario userError = new Usuario();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userError);
		}
	}
	

}
