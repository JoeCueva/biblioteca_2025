package com.biblioteca.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rol;
	
	private String roles;

	public rol(int id_rol, String roles) {
		super();
		this.id_rol = id_rol;
		this.roles = roles;
	}
	
	
	public rol() {
		
	}


	public int getId_rol() {
		return id_rol;
	}


	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_rol, roles);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		rol other = (rol) obj;
		return id_rol == other.id_rol && Objects.equals(roles, other.roles);
	}


	@Override
	public String toString() {
		return "rol [id_rol=" + id_rol + ", roles=" + roles + "]";
	}
	
}
