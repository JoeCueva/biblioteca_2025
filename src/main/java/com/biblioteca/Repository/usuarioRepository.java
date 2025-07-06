package com.biblioteca.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.Entity.usuario;

public interface usuarioRepository extends JpaRepository<usuario, Integer>{

}
