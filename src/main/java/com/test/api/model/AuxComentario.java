package com.test.api.model;
//	Clase Auxiliar para la creacion de los Objetos Comentario, Usuario, Reseña
public class AuxComentario {
	private String comentario;
	private Integer usuario_id;
	private Integer reseña_id;
	public AuxComentario(String comentario, Integer usuario_id, Integer reseña_id) {
		super();
		this.comentario = comentario;
		this.usuario_id = usuario_id;
		this.reseña_id = reseña_id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Integer getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}
	public Integer getReseña_id() {
		return reseña_id;
	}
	public void setReseña_id(Integer reseña_id) {
		this.reseña_id = reseña_id;
	}

}
