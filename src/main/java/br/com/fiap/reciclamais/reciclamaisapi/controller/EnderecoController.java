package br.com.fiap.reciclamais.reciclamaisapi.controller;

import br.com.fiap.reciclamais.reciclamaisapi.model.Endereco;
import br.com.fiap.reciclamais.reciclamaisapi.model.Estado;
import br.com.fiap.reciclamais.reciclamaisapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping("{cep}")
    public Endereco buscarPorCep(@PathVariable String cep){
        return repository.findById(cep).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }
}
