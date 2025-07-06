package com.biblioteca.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.biblioteca.Entity.trabajador;
import com.biblioteca.Entity.usuario;
import com.biblioteca.Service.CustomTrabajadorDetailsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class trabajadorController {
	
	
	private CustomTrabajadorDetailsService tb;
	
	
	@GetMapping("/SistemaBiblioteca-list")
	public String listTrabajador(Model model) {
		List<trabajador> trabajadorList = tb.getAll();
		model.addAttribute("trabajadorList", trabajadorList );
		
		for(trabajador trabajador: trabajadorList) {
			System.out.println(trabajador.getNombre());
			System.out.println(trabajador.getApellido());
			System.out.println(trabajador.getEmail());
			System.out.println(trabajador.getEdad());
			System.out.println(trabajador.getPassword());
			System.out.println(trabajador.getRol());
				
		}
		
		return "SistemaBiblioteca-list";
	}
	
	@ModelAttribute("trabajador")
	public trabajador getTrabajadorFromSession(HttpSession session) {
	    return (trabajador) session.getAttribute("usuario");
	}
	
	
	@GetMapping("/view-trabajador/{id}")
	public String showViewTrabajador(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("trabajador", tb.getTrabajador(id));
			model.addAttribute("type", "V");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trabajador";
	}
	
	
}
