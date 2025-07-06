package com.biblioteca.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.Entity.categoria;
import com.biblioteca.Repository.categoriaRepository;

@Service
public class categoriaService {
	
	@Autowired
	private categoriaRepository categoriaRepository;
	
	public categoria crear (categoria ct) throws Exception  {
		if(ct.getNombreCategoria() == null) {
			throw new Exception("debe de ingresar una categoria");
		}
		return categoriaRepository.save(ct);
	}
	
	public categoria editar(categoria ct) throws Exception {
		if(ct.getNombreCategoria() == null) {
			throw new Exception("Debe de ingresar una categoria");
		}
		categoria cateList = getCategoria(ct.getId_categoria());
		cateList.setNombreCategoria(ct.getNombreCategoria());
		return categoriaRepository.save(cateList);
	}
	
	public void eliminar(Integer id_categoria) {
		categoriaRepository.deleteById(id_categoria);
	}
	

	public categoria getCategoria(int id_categoria) throws Exception {
		Optional<categoria> optCategoria = categoriaRepository.findById(id_categoria);
		
		if (optCategoria.isEmpty()) {
			throw new Exception("La categoria con ID: " + id_categoria + " no existe");
		}
		
		return optCategoria.get();
	}
	
	public List<categoria> getAll() {
		return categoriaRepository.findAll();
	}
	
	
	
}
