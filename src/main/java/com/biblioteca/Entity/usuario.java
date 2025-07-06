package com.biblioteca.Entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@Column(name = "nombre_usuario")
	private String nombre_usuario;
	
	@Column(name = "apellido_usuario")
	private String apellido_usuario;
	private String dni;
	private String correo;
	private String telefono;
	private String direccion;
	private String genero;
	private LocalDate fecha_nacimiento;
	public usuario(Integer id_usuario, String nombre_usuario, String apellido_usuario, String dni, String correo,
			String telefono, String direccion, String genero, LocalDate fecha_nacimiento) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellido_usuario = apellido_usuario;
		this.dni = dni;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.genero = genero;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public usuario() {
		super();
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellido_usuario() {
		return apellido_usuario;
	}

	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido_usuario, correo, direccion, dni, fecha_nacimiento, genero, id_usuario,
				nombre_usuario, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		usuario other = (usuario) obj;
		return Objects.equals(apellido_usuario, other.apellido_usuario) && Objects.equals(correo, other.correo)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(dni, other.dni)
				&& Objects.equals(fecha_nacimiento, other.fecha_nacimiento) && Objects.equals(genero, other.genero)
				&& Objects.equals(id_usuario, other.id_usuario) && Objects.equals(nombre_usuario, other.nombre_usuario)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "usuario [id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario="
				+ apellido_usuario + ", dni=" + dni + ", correo=" + correo + ", telefono=" + telefono + ", direccion="
				+ direccion + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	
	
	
	
}
