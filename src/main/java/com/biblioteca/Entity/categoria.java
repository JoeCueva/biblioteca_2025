package com.biblioteca.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	public categoria(Integer id_categoria, String nombreCategoria) {
		super();
		this.id_categoria = id_categoria;
		this.nombreCategoria = nombreCategoria;
	}
	
	public categoria() {
		super();
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_categoria, nombreCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		categoria other = (categoria) obj;
		return Objects.equals(id_categoria, other.id_categoria)
				&& Objects.equals(nombreCategoria, other.nombreCategoria);
	}

	@Override
	public String toString() {
		return "categoria [id_categoria=" + id_categoria + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	

	
}
