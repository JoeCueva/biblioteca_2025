package com.biblioteca.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biblioteca.Entity.libros;

public interface librosRepository extends JpaRepository<libros, Integer>{
	
	
	 @Query(""" 
	 		select l from libros l
	 		where 
	 		(:id_autores is null or l.autores.id_autores = :id_autores)
	 		and
	 		(:id_categoria is null or l.categoria.id_categoria = :id_categoria)
	 		order by
	 		l.id_libros asc
	 		""")
	 List<libros> findAllWithFilters(@Param("id_autores") Integer id_autores, 
			 						@Param("id_categoria") Integer id_categoria);
}
