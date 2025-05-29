package com.formativajm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nome;
		private String cpf;
		private String rg;
		private String endereco;
		private String telefone;
		private String estadoCivil;

	}