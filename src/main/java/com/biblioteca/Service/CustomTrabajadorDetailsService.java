package com.biblioteca.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biblioteca.Entity.trabajador;
import com.biblioteca.Entity.usuario;
import com.biblioteca.Repository.trabajadorRepository;
import com.biblioteca.configuration.CustomTrabajadorDetails;

@Service
public class CustomTrabajadorDetailsService implements UserDetailsService {
	
	
	@Autowired
	private trabajadorRepository trabajadorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		trabajador trabajador = trabajadorRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No se encontro el trabajador con email : " + email));
	
			return new CustomTrabajadorDetails(trabajador);
	
	}
	
	public trabajador getTrabajador(Integer id_trabajador) throws Exception {
		Optional<trabajador> optTrabajador = trabajadorRepository.findById(id_trabajador);
		
		if (optTrabajador.isEmpty()) {
			throw new Exception("El usuario con ID: " + id_trabajador + " no existe");
		}
		
		return optTrabajador.get();
	}
	
	public List<trabajador> getAll() {
		return trabajadorRepository.findAll();
	}
	
	
	
}
