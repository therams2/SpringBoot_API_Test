package com.test.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
// Clase Identidad de Nuestro Objeto Usuario
@Entity
@Table(name = "usuarios")
public class Usuario {

	public static interface BaseUser {							
	}

	public static interface SingleUser extends BaseUser {		
	};

	@Id
	@JsonView(BaseUser.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(BaseUser.class)
	@Column(unique=true)
	private String email;
	@JsonView(SingleUser.class)
	private String password;
	@JsonView(BaseUser.class)
	private String username;
	@OneToMany(mappedBy = "usuario")							
	private List<Comentario> comentarios;
	@OneToMany(mappedBy = "usuario")							
	private List<Reseña> reseña;
	
	public Usuario() {}

	
	public Usuario(Integer id, String email, String password, String username, List<Comentario> comentarios
			) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.comentarios = comentarios;

	}



	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Reseña> getReseña() {
		return reseña;
	}

	public void setReseña(List<Reseña> reseña) {
		this.reseña = reseña;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
