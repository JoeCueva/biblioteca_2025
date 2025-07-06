package com.biblioteca.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class autores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_autores;
	@Column(name = "nombre_autores")
	private String nombreAutores;
	private String nacionalidad;
	
	public autores(Integer id_autores, String nombreAutores, String nacionalidad) {
		super();
		this.id_autores = id_autores;
		this.nombreAutores = nombreAutores;
		this.nacionalidad = nacionalidad;
	}

	public autores() {
		super();
	}

	public Integer getId_autores() {
		return id_autores;
	}

	public void setId_autores(Integer id_autores) {
		this.id_autores = id_autores;
	}

	public String getNombreAutores() {
		return nombreAutores;
	}

	public void setNombreAutores(String nombreAutores) {
		this.nombreAutores = nombreAutores;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_autores, nacionalidad, nombreAutores);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		autores other = (autores) obj;
		return Objects.equals(id_autores, other.id_autores) && Objects.equals(nacionalidad, other.nacionalidad)
				&& Objects.equals(nombreAutores, other.nombreAutores);
	}

	@Override
	public String toString() {
		return "autores [id_autores=" + id_autores + ", nombreAutores=" + nombreAutores + ", nacionalidad="
				+ nacionalidad + "]";
	}

	
	

}
