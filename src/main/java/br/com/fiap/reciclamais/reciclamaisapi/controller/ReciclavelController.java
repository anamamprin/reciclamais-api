package br.com.fiap.reciclamais.reciclamaisapi.controller;

import br.com.fiap.reciclamais.reciclamaisapi.model.Reciclavel;
import br.com.fiap.reciclamais.reciclamaisapi.repository.ReciclavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reciclavel")
public class ReciclavelController {

    @Autowired
    private ReciclavelRepository repository;

    @GetMapping
    public List<Reciclavel> listarTodos(){
        return repository.findAll();

    }

}
