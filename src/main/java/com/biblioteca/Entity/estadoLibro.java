package com.biblioteca.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class estadoLibro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estado;
	private String descripcion;
	public estadoLibro(Integer id_estado, String descripcion) {
		super();
		this.id_estado = id_estado;
		this.descripcion = descripcion;
	}
	
	public estadoLibro() {
		super();
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id_estado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		estadoLibro other = (estadoLibro) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id_estado, other.id_estado);
	}
	

	@Override
	public String toString() {
		return "estadoLibro [id_estado=" + id_estado + ", descripcion=" + descripcion + "]";
	}
	
	
}
