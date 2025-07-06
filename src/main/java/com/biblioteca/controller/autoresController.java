package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.Entity.autores;
import com.biblioteca.Service.autoresService;


@Controller
public class autoresController {

	@Autowired
	private autoresService autoresService;
	
	
	@GetMapping("/RegistroAutores-list")
	public String listAutores(Model model) {
		List<autores> autoresList = autoresService.getAll();
		model.addAttribute("autoresList", autoresList);
		
		for(autores autores: autoresList) {
			System.out.println(autores.getId_autores());
			System.out.println(autores.getNombreAutores());
			System.out.println(autores.getNacionalidad());
			
		}
		
		return "RegistroAutores-list";
	}
	
	
	@GetMapping("/new-autores")
	public String showNuevoAutores(Model model) {
		model.addAttribute("autores", new autores());
		model.addAttribute("type", "N");
		return "autores";
	}
	
	@GetMapping("/edit-autores/{id}")
	public String showEditAutores(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("autores", autoresService.getAutores(id));
			model.addAttribute("type", "E");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "autores";
	}
	
	@GetMapping("/remove-autores/{id}")
	public String removeAutores(@PathVariable Integer id, Model model) {
		autoresService.eliminar(id);
	
		return "redirect:/RegistroAutores-list";
	}
	
	@GetMapping("/view-autores/{id}")
	public String showViewAutores(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("autores", autoresService.getAutores(id));
			model.addAttribute("type", "V");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "autores";
	}
	
	@PostMapping("/save-new-autores")
	public String saveNewAutores(@ModelAttribute autores autores) {
		try {
			autoresService.crear(autores);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroAutores-list";
	}
	
	@PostMapping("/save-edit-autores")
	public String saveEditAutores(@ModelAttribute autores autores) {
		try {
			autoresService.editar(autores);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroAutores-list";
	}
	
}
