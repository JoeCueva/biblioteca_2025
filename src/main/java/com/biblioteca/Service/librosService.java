package com.biblioteca.Service;
import com.biblioteca.controller.principalController;
import com.biblioteca.dao.LibroFilter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.Entity.autores;
import com.biblioteca.Entity.libros;
import com.biblioteca.Repository.autoresRepository;
import com.biblioteca.Repository.categoriaRepository;
import com.biblioteca.Repository.estadolibroRepository;
import com.biblioteca.Repository.librosRepository;

@Service
public class librosService {
	
	@Autowired
	private librosRepository librosRepository;
	
	@Autowired
	private autoresRepository autoresRepository;
	
	@Autowired
	private categoriaRepository categoriaRepository;
	
	@Autowired
	private estadolibroRepository estadolibroRepository;
	
	
	public List<libros> search(LibroFilter filtro) {
		return librosRepository.findAllWithFilters(filtro.getId_autores(), filtro.getId_categoria());
	}
	
	public libros crear (libros ls) throws Exception  {
		if(ls.getTitulo() == null) {
			throw new Exception("debe de ingresar el titulo del libro");
		}
		
		if(ls.getAnio() == null) {
			throw new Exception("Debe de ingresar el año");
		}
		
		if(ls.getIsbn() == null) {
			throw new Exception("Debe de ingresar el isbn");
		}
		
		if(ls.getEditorial() == null) {
			throw new Exception("Debe de ingrear el editorial");
		}
		if(ls.getAutores() == null) {
			throw new Exception("Debe de ingrear el autor");
		}
		if(ls.getCategoria() == null) {
			throw new Exception("DEbe de ingresar la categoria");
		}
		if(ls.getEstadoLibro() == null) {
			throw new Exception("Debe de escoger el estado del libro");
		}
		
		return librosRepository.save(ls);
		
	}
	
	
	public libros editar(libros ls) throws Exception {
		if(ls.getTitulo() == null) {
			throw new Exception("debe de ingresar el titulo del libro");
		}
		
		if(ls.getAnio() == null) {
			throw new Exception("Debe de ingresar el año");
		}
		
		if(ls.getIsbn() == null) {
			throw new Exception("Debe de ingresar el isbn");
		}
		
		if(ls.getEditorial() == null) {
			throw new Exception("Debe de ingrear el editorial");
		}
		if(ls.getAutores() == null) {
			throw new Exception("Debe de ingrear el autor");
		}
		if(ls.getCategoria() == null) {
			throw new Exception("DEbe de ingresar la categoria");
		}
		if(ls.getEstadoLibro() == null) {
			throw new Exception("Debe de escoger el estado del libro");
		}
		
		libros libroList = getLibros(ls.getId_libros());
		libroList.setTitulo(ls.getTitulo());
		libroList.setAnio(ls.getAnio());
		libroList.setIsbn(ls.getIsbn());
		libroList.setEditorial(ls.getEditorial());
		libroList.setAutores(ls.getAutores());
		libroList.setCategoria(ls.getCategoria());
		libroList.setEstadoLibro(ls.getEstadoLibro());
		return librosRepository.save(ls);
	}
	
	public void eliminar(Integer id_libros) {
		librosRepository.deleteById(id_libros);
	}

	public libros getLibros(Integer id_libros) throws Exception {
		Optional<libros> optLibros = librosRepository.findById(id_libros);
		
		if (optLibros.isEmpty()) {
			throw new Exception("El libro con ID: " + id_libros + " no existe");
		}
		
		return optLibros.get();
	}
	
	public List<libros> getAll() {
		return librosRepository.findAll();
	}
	
}
