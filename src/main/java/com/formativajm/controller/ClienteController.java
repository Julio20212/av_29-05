package com.formativajm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formativajm.entity.Cliente;
import com.formativajm.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Módulo de Clientes - ", description = "API REST - GERENCIAMENTO DE CLIENTES")
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@Operation(summary = "Localizar cliente por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente cliente = clienteService.getClienteById(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(summary = "Localizar todos clientes")
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> clientes = clienteService.getAllClientes();
		return ResponseEntity.ok(clientes);
	}

	// Query Method
	@Operation(summary = "Localizar nome do cliente")
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> buscarClientesPorNome(@PathVariable String nome) {
		List<Cliente> clientes = clienteService.buscarClientesPorNome(nome);
		return ResponseEntity.ok(clientes);
	}

	@Operation(summary = "Criar cliente")
	@PostMapping("/")
	public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid Cliente cliente) {
		Cliente criarCliente = clienteService.salvarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarCliente);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Alterar cliente pelo ID")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
		Cliente updatedCliente = clienteService.updateCliente(id, cliente);
		if (updatedCliente != null) {
			return ResponseEntity.ok(updatedCliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(summary = "Deletar cliente pelo ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteProduto(@PathVariable Long id) {
		boolean deleted = clienteService.deleteCliente(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}