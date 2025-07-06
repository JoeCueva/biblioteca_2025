package com.biblioteca.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.Entity.categoria;
import com.biblioteca.Entity.estadoLibro;
import com.biblioteca.Repository.estadolibroRepository;

@Service
public class estadolibroService {

	@Autowired
	public estadolibroRepository estadolibroRepository;
	
	public List<estadoLibro> getAll() {
		return estadolibroRepository.findAll();
	}
	
	
}
