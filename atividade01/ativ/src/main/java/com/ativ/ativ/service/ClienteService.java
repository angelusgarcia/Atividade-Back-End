package com.ativ.ativ.service;

import com.ativ.ativ.model.Cliente;
import com.ativ.ativ.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        cliente.setAtivo(true);
        cliente.setDataCadastro(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }
}