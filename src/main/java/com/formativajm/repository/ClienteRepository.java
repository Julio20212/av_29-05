package com.formativajm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formativajm.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{
	List <Cliente> findByNome (String nome);
}
