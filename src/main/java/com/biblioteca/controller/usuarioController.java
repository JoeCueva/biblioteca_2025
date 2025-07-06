package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.Entity.usuario;
import com.biblioteca.Service.usuarioService;

@Controller
public class usuarioController {

	@Autowired
	private usuarioService usuarioService;
	
	@GetMapping("/RegistroUsuario-list")
	public String listUsuario(Model model) {
		List<usuario> usuarioList = usuarioService.getAll();
		model.addAttribute("usuarioList", usuarioList);
		
		for(usuario usuario: usuarioList) {
			System.out.println(usuario.getNombre_usuario());
			System.out.println(usuario.getApellido_usuario());
			System.out.println(usuario.getDni());
			System.out.println(usuario.getCorreo());
			System.out.println(usuario.getTelefono());
			System.out.println(usuario.getDireccion());
			System.out.println(usuario.getGenero());
			System.out.println(usuario.getFecha_nacimiento());
			
		}
		
		return "RegistroUsuario-list";
	}
	
	
	@GetMapping("/new-usuario")
	public String showNuevoUsuario(Model model) {
		model.addAttribute("usuario", new usuario());
		model.addAttribute("type", "N");
		return "usuario";
	}
	
	@GetMapping("/edit-usuario/{id}")
	public String showEditUsuario(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("usuario", usuarioService.getUsuario(id));
			model.addAttribute("type", "E");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@GetMapping("/remove-usuario/{id}")
	public String removeUsuario(@PathVariable Integer id, Model model) {
		usuarioService.eliminar(id);
	
		return "redirect:/RegistroUsuario-list";
	}
	
	@GetMapping("/view-usuario/{id}")
	public String showViewUsuario(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("usuario", usuarioService.getUsuario(id));
			model.addAttribute("type", "V");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@PostMapping("/save-new-usuario")
	public String saveNewUsuario(@ModelAttribute usuario usuario) {
		try {
			usuarioService.crear(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroUsuario-list";
	}
	
	@PostMapping("/save-edit-usuario")
	public String saveEditUsuario(@ModelAttribute usuario usuario) {
		try {
			usuarioService.editar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroUsuario-list";
	}
	
}
