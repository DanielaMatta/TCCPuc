package com.academia.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.domain.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	
	
	

}
