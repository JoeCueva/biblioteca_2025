package com.biblioteca.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class prestamos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prestamos;
	
	@ManyToOne
	@JoinColumn(name="id_usuario" ,referencedColumnName = "id_usuario")
	private usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_libros", referencedColumnName = "id_libros")
	private libros libros;
	
	private LocalDate fecha_prestamo;
	private LocalDate fecha_devolucion;
	private LocalDate fecha_real;
	
	private BigDecimal multa;
	
	@ManyToOne
	@JoinColumn(name="id_estado" , referencedColumnName = "id_estado")
	private estadoLibro estadoLibro;
	
	private String comentarios;

	public prestamos(int id_prestamos, com.biblioteca.Entity.usuario usuario, com.biblioteca.Entity.libros libros,
			LocalDate fecha_prestamo, LocalDate fecha_devolucion, LocalDate fecha_real, BigDecimal multa,
			com.biblioteca.Entity.estadoLibro estadoLibro, String comentarios) {
		super();
		this.id_prestamos = id_prestamos;
		this.usuario = usuario;
		this.libros = libros;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
		this.fecha_real = fecha_real;
		this.multa = multa;
		this.estadoLibro = estadoLibro;
		this.comentarios = comentarios;
	}

	public prestamos() {
		super();
	}

	public int getId_prestamos() {
		return id_prestamos;
	}

	public void setId_prestamos(int id_prestamos) {
		this.id_prestamos = id_prestamos;
	}

	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}

	public libros getLibros() {
		return libros;
	}

	public void setLibros(libros libros) {
		this.libros = libros;
	}

	public LocalDate getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(LocalDate fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public LocalDate getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(LocalDate fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public LocalDate getFecha_real() {
		return fecha_real;
	}

	public void setFecha_real(LocalDate fecha_real) {
		this.fecha_real = fecha_real;
	}

	public BigDecimal getMulta() {
		return multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public estadoLibro getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(estadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentarios, estadoLibro, fecha_devolucion, fecha_prestamo, fecha_real, id_prestamos,
				libros, multa, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		prestamos other = (prestamos) obj;
		return Objects.equals(comentarios, other.comentarios) && Objects.equals(estadoLibro, other.estadoLibro)
				&& Objects.equals(fecha_devolucion, other.fecha_devolucion)
				&& Objects.equals(fecha_prestamo, other.fecha_prestamo) && Objects.equals(fecha_real, other.fecha_real)
				&& id_prestamos == other.id_prestamos && Objects.equals(libros, other.libros)
				&& Objects.equals(multa, other.multa) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "prestamos [id_prestamos=" + id_prestamos + ", usuario=" + usuario + ", libros=" + libros
				+ ", fecha_prestamo=" + fecha_prestamo + ", fecha_devolucion=" + fecha_devolucion + ", fecha_real="
				+ fecha_real + ", multa=" + multa + ", estadoLibro=" + estadoLibro + ", comentarios=" + comentarios
				+ "]";
	}

	
	
}
