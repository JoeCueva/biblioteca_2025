package com.biblioteca.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.Entity.autores;
import com.biblioteca.Repository.autoresRepository;

@Service
public class autoresService {

	@Autowired
	private autoresRepository autoresRepository;
	
	public autores crear (autores at) throws Exception  {
		if(at.getNombreAutores() == null) {
			throw new Exception("debe de ingresar un nombre del autor");
		}
		if(at.getNacionalidad() == null) {
			throw new Exception("debe de ingresar su nacionalidad");
		}
		return autoresRepository.save(at);
	}
	
	public autores editar(autores at) throws Exception {
		if(at.getNombreAutores() == null) {
			throw new Exception("debe de ingresar un nombre del autor");
		}
		if(at.getNacionalidad() == null) {
			throw new Exception("debe de ingresar su nacionalidad");
		}
		autores autoList = getAutores(at.getId_autores());
		autoList.setNombreAutores(at.getNombreAutores());
		autoList.setNacionalidad(at.getNacionalidad());
		return autoresRepository.save(at);
	}
	
	public void eliminar(Integer id_autores) {
		autoresRepository.deleteById(id_autores);
	}
	

	public autores getAutores(int id_autores) throws Exception {
		Optional<autores> optAutores = autoresRepository.findById(id_autores);
		
		if (optAutores.isEmpty()) {
			throw new Exception("El autor con ID: " + id_autores + " no existe");
		}
		
		return optAutores.get();
	}
	
	public List<autores> getAll() {
		return autoresRepository.findAll();
	}
}
