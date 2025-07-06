package com.biblioteca.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.Entity.usuario;
import com.biblioteca.Repository.usuarioRepository;


@Service
public class usuarioService {
	
	@Autowired
	private usuarioRepository usuarioRepository;
	
	public usuario crear (usuario user) throws Exception  {
		if(user.getNombre_usuario() == null) {
			throw new Exception("debe de ingresar el nombre del usuario");
		}
		if(user.getApellido_usuario() == null) {
			throw new Exception("debe de ingresar el apellido del usuario");
		}
		if(user.getDni() == null) {
			throw new Exception("debe de ingresar el dni del usuario");
		}
		if(user.getCorreo() == null) {
			throw new Exception("debe de ingresar el correo del usuario");
		}
		if(user.getTelefono() == null) {
			throw new Exception("debe de ingresar el telegfono del usuario");
		}
		if(user.getDireccion() == null) {
			throw new Exception("debe de ingresar la direccion del usuario");
		}
		if(user.getGenero() == null) {
			throw new Exception("debe de ingresar el genero del usuario");
		}
		if(user.getFecha_nacimiento() == null) {
			throw new Exception("debe de ingresar la fecha de nacimiento del usuario");
		}
		
		return usuarioRepository.save(user);
	}
	
	
	public usuario editar(usuario user) throws Exception {
		if(user.getNombre_usuario() == null) {
			throw new Exception("debe de ingresar el nombre del usuario");
		}
		if(user.getApellido_usuario() == null) {
			throw new Exception("debe de ingresar el apellido del usuario");
		}
		if(user.getDni() == null) {
			throw new Exception("debe de ingresar el dni del usuario");
		}
		if(user.getCorreo() == null) {
			throw new Exception("debe de ingresar el correo del usuario");
		}
		if(user.getTelefono() == null) {
			throw new Exception("debe de ingresar el telegfono del usuario");
		}
		if(user.getDireccion() == null) {
			throw new Exception("debe de ingresar la direccion del usuario");
		}
		if(user.getGenero() == null) {
			throw new Exception("debe de ingresar el genero del usuario");
		}
		if(user.getFecha_nacimiento() == null) {
			throw new Exception("debe de ingresar la fecha de nacimiento del usuario");
		}
		usuario usuarioList = getUsuario(user.getId_usuario());
		usuarioList.setNombre_usuario(user.getNombre_usuario());
		usuarioList.setApellido_usuario(user.getApellido_usuario());
		usuarioList.setDni(user.getDni());
		usuarioList.setCorreo(user.getCorreo());
		usuarioList.setTelefono(user.getTelefono());
		usuarioList.setDireccion(user.getDireccion());
		usuarioList.setGenero(user.getGenero());
		usuarioList.setFecha_nacimiento(user.getFecha_nacimiento());
		return usuarioRepository.save(usuarioList);
	}
	
	public void eliminar(Integer id_usuario) {
		usuarioRepository.deleteById(id_usuario);
	}

	

	public usuario getUsuario(Integer id_usuario) throws Exception {
		Optional<usuario> optUsuario = usuarioRepository.findById(id_usuario);
		
		if (optUsuario.isEmpty()) {
			throw new Exception("El usuario con ID: " + id_usuario + " no existe");
		}
		
		return optUsuario.get();
	}
	
	public List<usuario> getAll() {
		return usuarioRepository.findAll();
	}
	
	
}
