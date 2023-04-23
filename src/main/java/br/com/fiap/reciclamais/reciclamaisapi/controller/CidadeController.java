package br.com.fiap.reciclamais.reciclamaisapi.controller;

import br.com.fiap.reciclamais.reciclamaisapi.model.Bairro;
import br.com.fiap.reciclamais.reciclamaisapi.model.Cidade;
import br.com.fiap.reciclamais.reciclamaisapi.repository.BairroRepository;
import br.com.fiap.reciclamais.reciclamaisapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @Autowired
    private BairroRepository bairroRepository;

    @GetMapping("{codigo}")
    public Cidade buscarPorId(@PathVariable long codigo){
        return repository.findById(codigo).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    @GetMapping("{codigo}/bairros")
    public List<Bairro> buscarCidades(@PathVariable long codigo){
        return bairroRepository.findByCidade_Codigo(codigo);
    }

}
