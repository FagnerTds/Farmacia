package com.generation.farmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public long id;
	
	@NotBlank(message="O atributo nome é obrigatório")
	public String nome;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message="O atributo usuário é obrigatório, digite o email")
	@Email(message = "O Atributo Usuário deve ser um email válido!")
	public String usuario;
	
	@NotBlank(message="O atributo senha e obrigatório")
	@Size(min=8, message= "A senha deve ter no mínimo 8 Caracteres")
	public String senha;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	public String foto;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy= "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	public List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
	
}
