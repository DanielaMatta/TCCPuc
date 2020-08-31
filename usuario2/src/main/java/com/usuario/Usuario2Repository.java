package com.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuario2Repository extends JpaRepository <Usuario, Long> {

	public String findEmailByNomeAndSenha (String nome, String senha);
	
	
}
