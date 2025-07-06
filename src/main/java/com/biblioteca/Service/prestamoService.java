package com.biblioteca.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.Entity.prestamos;
import com.biblioteca.Repository.estadolibroRepository;
import com.biblioteca.Repository.librosRepository;
import com.biblioteca.Repository.prestamosRepository;
import com.biblioteca.Repository.usuarioRepository;

@Service
public class prestamoService {
	
	@Autowired
	private prestamosRepository prestamosRepository;
	
	@Autowired
	private usuarioRepository usuarioRepository;
	
	@Autowired
	private librosRepository librosRepository;
	
	@Autowired
	private estadolibroRepository estadolibroRepository;
	
	
	
	
	public prestamos crear(prestamos ps) throws Exception{
		
		if(ps.getUsuario() == null) {
			throw new Exception("debe de ingresar el usuario para el prestamo");
		}
		if(ps.getLibros() == null) {
			throw new Exception("debe de ingresar el Libro para el prestamo");
		}
		if(ps.getFecha_prestamo() == null) {
			throw new Exception("debe de ingresar la fecha  para el prestamo");
		}
		if(ps.getFecha_devolucion() == null) {
			throw new Exception("debe de ingresar el devolucion para el prestamo");
		}
		if(ps.getFecha_real() == null) {
			throw new Exception("debe de ingresar la fecha real para la devolcuion del libro");
		}
		if(ps.getMulta() == null) {
			throw new Exception("debe de ingresar la multa para el prestamo");
		}
		if(ps.getEstadoLibro()== null) {
			throw new Exception("debe de ingresar el estado del libro");
		}
		if(ps.getComentarios() == null) {
			throw new Exception("debe de ingresar los comentarios");
		}
		
		return prestamosRepository.save(ps);
	}
	
	
	public prestamos editar(prestamos ps) throws Exception {
		if(ps.getUsuario() == null) {
			throw new Exception("debe de ingresar el usuario para el prestamo");
		}
		if(ps.getLibros() == null) {
			throw new Exception("debe de ingresar el Libro para el prestamo");
		}
		if(ps.getFecha_prestamo() == null) {
			throw new Exception("debe de ingresar la fecha  para el prestamo");
		}
		if(ps.getFecha_devolucion() == null) {
			throw new Exception("debe de ingresar el devolucion para el prestamo");
		}
		if(ps.getFecha_real() == null) {
			throw new Exception("debe de ingresar la fecha real para la devolcuion del libro");
		}
		if(ps.getMulta() == null) {
			throw new Exception("debe de ingresar la multa para el prestamo");
		}
		if(ps.getEstadoLibro()== null) {
			throw new Exception("debe de ingresar el estado del libro");
		}
		if(ps.getComentarios() == null) {
			throw new Exception("debe de ingresar los comentarios");
		}	
		
		prestamos prestamoList = getPrestamos(ps.getId_prestamos());
		prestamoList.setUsuario(ps.getUsuario());
		prestamoList.setLibros(ps.getLibros());
		prestamoList.setFecha_prestamo(ps.getFecha_prestamo());
		prestamoList.setFecha_devolucion(ps.getFecha_devolucion());
		prestamoList.setFecha_real(ps.getFecha_real());
		prestamoList.setMulta(ps.getMulta());
		prestamoList.setEstadoLibro(ps.getEstadoLibro());
		prestamoList.setComentarios(ps.getComentarios());
		return prestamosRepository.save(prestamoList);
	}
	
	
	public void eliminar(Integer id_prestamos) {
		prestamosRepository.deleteById(id_prestamos);
	}
	
	
	
	
		public prestamos getPrestamos(int id_prestamos) throws Exception {
			Optional<prestamos> optPrestamos = prestamosRepository.findById(id_prestamos);
			
			if (optPrestamos.isEmpty()) {
				throw new Exception("El prestamo con ID: " + id_prestamos + " no existe");
			}
			
			return optPrestamos.get();
		}
	
		public List<prestamos> getAll() {
			return prestamosRepository.findAll();
		}
}


