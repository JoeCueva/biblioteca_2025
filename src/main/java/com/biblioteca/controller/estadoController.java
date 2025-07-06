package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.Entity.categoria;
import com.biblioteca.Entity.estadoLibro;
import com.biblioteca.Service.estadolibroService;


@Controller
public class estadoController {
	
	@Autowired
	private estadolibroService estadolibroService;
	
	
	@GetMapping("/new-estado-list")
	public String listEstado(Model model) {
		List<estadoLibro> estadoList = estadolibroService.getAll();
		model.addAttribute("estadoList", estadoList);
		
		for(estadoLibro estado: estadoList) {
			System.out.println(estado.getId_estado());
			System.out.println(estado.getDescripcion());
			
		}
		
		return "new-estado-list";
	}
	
}
