package com.biblioteca.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.Entity.trabajador;

public interface trabajadorRepository extends JpaRepository<trabajador, Integer>{
	Optional<trabajador> findByEmail(String email);
}


