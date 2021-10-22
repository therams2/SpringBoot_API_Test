package com.test.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
//	Clase Identidad de Nuestro Objeto Comentario
@Entity
@Table(name = "comentarios")
public class Comentario {
	public static interface BaseComentario {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(BaseComentario.class)
	private String comentario;
	// Parametro Relacion Comentarios - Reseña

	@ManyToOne
	private Reseña reseña;
	@JsonView(BaseComentario.class)
	@ManyToOne
	private Usuario usuario;

	public Comentario() {
		// TODO Auto-generated constructor stub
	}

	public Comentario(Integer id, String comentario) {
		super();
		this.id = id;
		this.comentario = comentario;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Reseña getReseña() {
		return reseña;
	}

	public void setReseña(Reseña reseña) {
		this.reseña = reseña;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
