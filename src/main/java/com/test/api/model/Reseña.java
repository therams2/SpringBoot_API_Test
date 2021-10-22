package com.test.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.test.api.model.Comentario.BaseComentario;
import com.test.api.model.Usuario.BaseUser;
//	Clase Identidad de Nuestro Objeto Reseña
@Entity
@Table(name = "reseñas")
public class Reseña {
	public static interface BaseReseña extends BaseUser, BaseComentario {		
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(BaseReseña.class)
	@Column(columnDefinition = "TEXT")
	private String reseña;
	// Relacion Reseña a Comentarios
	@JsonView(BaseReseña.class)
	@OneToMany(mappedBy = "reseña")
	private List<Comentario> comentarios;
	// Relacion Reseña - Usuario
	@JsonView(BaseReseña.class)
	@ManyToOne
	private Usuario usuario;
	// Relacion Reseñas - Libro
	@OneToOne
	private Libro libro;
	public Reseña() {}
	public Reseña(Integer id, String reseña) {
		super();
		this.id = id;
		this.reseña = reseña;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReseña() {
		return reseña;
	}

	public void setReseña(String reseña) {
		this.reseña = reseña;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
