package com.ativ.ativ.controller;

import com.ativ.ativ.model.Cliente;
import com.ativ.ativ.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            return ResponseEntity.badRequest().body("Nome obrigatório");
        }
        try {
            return ResponseEntity.ok(clienteService.cadastrar(cliente));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}