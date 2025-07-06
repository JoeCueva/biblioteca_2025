package com.biblioteca.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.biblioteca.Entity.trabajador;
import com.biblioteca.Service.CustomTrabajadorDetailsService;
import com.biblioteca.configuration.CustomTrabajadorDetails;

import jakarta.servlet.http.HttpSession;

@Controller
public class principalController {

    private final CustomTrabajadorDetailsService customTrabajadorDetailsService;


    principalController(CustomTrabajadorDetailsService customTrabajadorDetailsService) {
        this.customTrabajadorDetailsService = customTrabajadorDetailsService;
    }
	
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if(error != null) 
			model.addAttribute("mensaje" , "Correo o contraseña incorrectas");
		
		if(logout != null) 
			model.addAttribute("mensaje" , "Sesion cerrada correctamente");
		
		return "login";
	}
	

	@GetMapping("/bienvenido")
	public String mostrarBienvenida(HttpSession session, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null && auth.getPrincipal() instanceof CustomTrabajadorDetails) {
			CustomTrabajadorDetails userDetails = (CustomTrabajadorDetails) auth.getPrincipal();
			trabajador tbl = userDetails.getTrabajador();
			model.addAttribute("trabajador", tbl);
			
		}
		
		return "SistemaBiblioteca";
	}
	
	@GetMapping("/verPerfil")
	public String verPerfil(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null && auth.getPrincipal() instanceof CustomTrabajadorDetails) {
			CustomTrabajadorDetails userDetails = (CustomTrabajadorDetails) auth.getPrincipal();
			trabajador tbl = userDetails.getTrabajador();
			model.addAttribute("trabajador", tbl);
			
		}
		
		return "verPerfil";
	}
}
