package br.com.fiap.reciclamais.reciclamaisapi.controller;

import br.com.fiap.reciclamais.reciclamaisapi.model.Cidade;
import br.com.fiap.reciclamais.reciclamaisapi.model.Estado;
import br.com.fiap.reciclamais.reciclamaisapi.repository.CidadeRepository;
import br.com.fiap.reciclamais.reciclamaisapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estado")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public List<Estado> listarTodos(){
        return repository.findAll();
    }

    @GetMapping("{codigo}/cidades")
    public List<Cidade> buscarCidades(@PathVariable String codigo){
        return cidadeRepository.findByEstado_Uf(codigo);
    }

}
