package br.com.fiap.reciclamais.reciclamaisapi.controller;

import br.com.fiap.reciclamais.reciclamaisapi.model.Usuario;
import br.com.fiap.reciclamais.reciclamaisapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario){
        usuario.setAtivo(true);
        return repository.save(usuario);
    }

    @DeleteMapping("{codigo}")
    public void deletar(@PathVariable long codigo){
       Usuario usuario = repository.findById(codigo).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        usuario.setAtivo(false);
        repository.save(usuario);
    }

    @PutMapping("{codigo}")
    public Usuario atualizar(@PathVariable long codigo, @RequestBody Usuario usuario){
        repository.findById(codigo).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        usuario.setCodigo(codigo);
        return repository.save(usuario);
    }

    @GetMapping("{codigo}")
    public Usuario buscarPorId(@PathVariable long codigo){
        return repository.findById(codigo).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }
}
