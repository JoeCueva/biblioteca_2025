package com.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.Entity.estadoLibro;

public interface estadolibroRepository extends JpaRepository<estadoLibro, Integer> {

}
