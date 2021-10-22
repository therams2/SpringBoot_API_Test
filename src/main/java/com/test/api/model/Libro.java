package com.test.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.test.api.model.Reseña.BaseReseña;
//	Clase Identidad de Nuestro Objeto Libro
@Entity
@Table(name = "libros")

public class Libro {

	public static interface BaseLibro extends BaseReseña { //Interfaz para regresar al usuario una lista con los parametros id,titulo,sinopsis,portada
	}

	public static interface SingleLibro extends BaseLibro {
	};

	@JsonView(BaseLibro.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(BaseLibro.class)
	private String titulo;
	@JsonView(BaseLibro.class)
	@Column(columnDefinition = "TEXT")
	private String sinopsis;
	@JsonView(BaseLibro.class)
	private String portada;
	private Date fecha_publicacion;
	@JsonView(SingleLibro.class)
	@OneToOne(mappedBy = "libro")
	private Reseña reseñas;
	public Libro() {	}

	public Libro(Integer id, String titulo, String sinopsis, String portada, Date fecha_publicacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.portada = portada;
		this.fecha_publicacion = fecha_publicacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public Reseña getReseñas() {
		return reseñas;
	}

	public void setReseñas(Reseña reseñas) {
		this.reseñas = reseñas;
	}

}
