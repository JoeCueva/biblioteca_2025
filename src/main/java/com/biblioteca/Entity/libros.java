package com.biblioteca.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="libros")
public class libros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_libros;
	private String titulo;
	private Integer anio;
	private String isbn;
	private String editorial;	
	
	
	@ManyToOne
	@JoinColumn(name = "id_autores", referencedColumnName = "id_autores")
	private autores autores;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private categoria categoria;
	
	
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
	private estadoLibro estadoLibro;


	public libros(Integer id_libros, String titulo, Integer anio, String isbn, String editorial,
			com.biblioteca.Entity.autores autores, com.biblioteca.Entity.categoria categoria,
			com.biblioteca.Entity.estadoLibro estadoLibro) {
		super();
		this.id_libros = id_libros;
		this.titulo = titulo;
		this.anio = anio;
		this.isbn = isbn;
		this.editorial = editorial;
		this.autores = autores;
		this.categoria = categoria;
		this.estadoLibro = estadoLibro;
	}


	public libros() {
		super();
	}


	public Integer getId_libros() {
		return id_libros;
	}


	public void setId_libros(Integer id_libros) {
		this.id_libros = id_libros;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Integer getAnio() {
		return anio;
	}


	public void setAnio(Integer anio) {
		this.anio = anio;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public autores getAutores() {
		return autores;
	}


	public void setAutores(autores autores) {
		this.autores = autores;
	}


	public categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}


	public estadoLibro getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(estadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anio, autores, categoria, editorial, estadoLibro, id_libros, isbn, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		libros other = (libros) obj;
		return Objects.equals(anio, other.anio) && Objects.equals(autores, other.autores)
				&& Objects.equals(categoria, other.categoria) && Objects.equals(editorial, other.editorial)
				&& Objects.equals(estadoLibro, other.estadoLibro) && Objects.equals(id_libros, other.id_libros)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "libros [id_libros=" + id_libros + ", titulo=" + titulo + ", anio=" + anio + ", isbn=" + isbn
				+ ", editorial=" + editorial + ", autores=" + autores + ", categoria=" + categoria + ", estadoLibro="
				+ estadoLibro + "]";
	}	
	
}
