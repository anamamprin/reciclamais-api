package br.com.fiap.reciclamais.reciclamaisapi.controller;

import br.com.fiap.reciclamais.reciclamaisapi.model.Bairro;
import br.com.fiap.reciclamais.reciclamaisapi.model.Endereco;
import br.com.fiap.reciclamais.reciclamaisapi.repository.BairroRepository;
import br.com.fiap.reciclamais.reciclamaisapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("bairro")
public class BairroController {
    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("{codigo}")
    public Bairro buscarPorId(@PathVariable long codigo){
        return bairroRepository.findById(codigo).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    @GetMapping
    public List<Bairro> listaTodos(){
        return bairroRepository.findAll();
    }


    @GetMapping("{codigoBairro}/enderecos")
    public List<Endereco>listarEnderecos(@PathVariable Integer codigoBairro){
        return enderecoRepository.findByBairro_Codigo(codigoBairro);
    }

}
