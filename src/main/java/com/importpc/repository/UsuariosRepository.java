package com.importpc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.importpc.models.UsuariosEntity;


@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {
	
	@Query("SELECT u FROM UsuariosEntity u WHERE u.datDesativacao is null")
	List< UsuariosEntity > findAtivos();
	
	@Query("SELECT u FROM UsuariosEntity u WHERE u.dcrLogin = :name")
	List< UsuariosEntity > findUser(@Param("name") String name);
	 
}

