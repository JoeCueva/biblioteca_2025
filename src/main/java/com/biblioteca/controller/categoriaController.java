package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.Entity.categoria;
import com.biblioteca.Service.categoriaService;

@Controller
public class categoriaController {
	
	@Autowired
	private categoriaService categoriaService;
	
	
	@GetMapping("/RegistroCategoria-list")
	public String listCategoria(Model model) {
		List<categoria> categoriaList = categoriaService.getAll();
		model.addAttribute("categoriaList", categoriaList);
		
		for(categoria categoria: categoriaList) {
			System.out.println(categoria.getId_categoria());
			System.out.println(categoria.getNombreCategoria());
			
		}
		
		return "RegistroCategoria-list";
	}
	
	
	@GetMapping("/new-categoria")
	public String showNuevaCategoria(Model model) {
		model.addAttribute("categoria", new categoria());
		model.addAttribute("type", "N");
		return "categoria";
	}
	
	@GetMapping("/edit-categoria/{id}")
	public String showEditCategoria(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("categoria", categoriaService.getCategoria(id));
			model.addAttribute("type", "E");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoria";
	}
	
	@GetMapping("/remove-categoria/{id}")
	public String removeCategoria(@PathVariable Integer id, Model model) {
		categoriaService.eliminar(id);
	
		return "redirect:/RegistroCategoria-list";
	}
	
	@GetMapping("/view-categoria/{id}")
	public String showViewCategoria(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("categoria", categoriaService.getCategoria(id));
			model.addAttribute("type", "V");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoria";
	}
	
	@PostMapping("/save-new-categoria")
	public String saveNewCategoria(@ModelAttribute categoria categoria) {
		try {
			categoriaService.crear(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroCategoria-list";
	}
	
	@PostMapping("/save-edit-categoria")
	public String saveEditCategoria(@ModelAttribute categoria categoria) {
		try {
			categoriaService.editar(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroCategoria-list";
	}
	
}
