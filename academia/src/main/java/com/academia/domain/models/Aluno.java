package com.academia.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome_aluno;
	private String rg_aluno;
	private String email_aluno;
	private String endereco;
	private String telefone;
	private int dia_vencimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_aluno() {
		return nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}
	public String getRg_aluno() {
		return rg_aluno;
	}
	public void setRg_aluno(String rg_aluno) {
		this.rg_aluno = rg_aluno;
	}
	public String getEmail_aluno() {
		return email_aluno;
	}
	public void setEmail_aluno(String email_aluno) {
		this.email_aluno = email_aluno;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getDia_vencimento() {
		return dia_vencimento;
	}
	public void setDia_vencimento(int dia_vencimento) {
		this.dia_vencimento = dia_vencimento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
			

}
