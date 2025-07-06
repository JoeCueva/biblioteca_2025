package com.biblioteca.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trabajadores")
public class trabajador {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id_trabajador;
	public String nombre;
	public String apellido;
	public String email;
	public int edad;
	public String password;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	public rol rol;

	public trabajador(int id_trabajador, String nombre, String apellido, String email, int edad, String password,
			com.biblioteca.Entity.rol rol) {
		super();
		this.id_trabajador = id_trabajador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
		this.password = password;
		this.rol = rol;
	}
	
	public trabajador() {
		
	}

	public int getId_trabajador() {
		return id_trabajador;
	}

	public void setId_trabajador(int id_trabajador) {
		this.id_trabajador = id_trabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public rol getRol() {
		return rol;
	}

	public void setRol(rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, edad, email, id_trabajador, nombre, password, rol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		trabajador other = (trabajador) obj;
		return Objects.equals(apellido, other.apellido) && edad == other.edad && Objects.equals(email, other.email)
				&& id_trabajador == other.id_trabajador && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(rol, other.rol);
	}

	@Override
	public String toString() {
		return "trabajador [id_trabajador=" + id_trabajador + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", edad=" + edad + ", password=" + password + ", rol=" + rol + "]";
	}
	
}
