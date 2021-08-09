package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id  // id primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto_incremente
	private long id;

	@NotNull(message = "O atributo título é obrigatório")  // nãp pode ser vazio
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;	 // varchar (100)

	@NotNull(message = "O atributo texto é obrigatório")
	@Size(min = 10, max = 500, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto;

	@Temporal(TemporalType.TIMESTAMP)	// data_time
	private Date data = new java.sql.Date(System.currentTimeMillis());		// pega a data atual e preenche automaticamente
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
		
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private Usuario usuario;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
