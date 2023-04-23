package br.com.fiap.reciclamais.reciclamaisapi.controller;

import br.com.fiap.reciclamais.reciclamaisapi.model.Oferta;
import br.com.fiap.reciclamais.reciclamaisapi.model.Reciclavel;
import br.com.fiap.reciclamais.reciclamaisapi.model.Usuario;
import br.com.fiap.reciclamais.reciclamaisapi.repository.OfertaRepository;
import br.com.fiap.reciclamais.reciclamaisapi.repository.ReciclavelRepository;
import br.com.fiap.reciclamais.reciclamaisapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("oferta")
public class OfertaController {

    @Autowired
    private OfertaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReciclavelRepository reciclavelRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Oferta cadastrar(@RequestBody Oferta oferta){
        Usuario usuario = usuarioRepository.findById(oferta.getUsuario().getCodigo())
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));

        Reciclavel reciclavel = reciclavelRepository.findById(oferta.getReciclavel().getCodigo())
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));

        oferta.setData(LocalDateTime.now());
        oferta.setTipo(oferta.getTipo().toLowerCase());
        oferta.setUsuario(usuario);
        oferta.setReciclavel(reciclavel);
        return repository.save(oferta);
    }

    @DeleteMapping("{codigo}")
    public void deletar(@PathVariable long codigo) {
        repository.findById(codigo).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        repository.deleteById(codigo);
    }

    @GetMapping("{tipo}")
    public List<Oferta> listarPorTipo(@PathVariable String tipo,
                                      @RequestParam(required = false) Integer codigoReciclavel){
       if(codigoReciclavel != null){
           return repository.findByTipoAndReciclavel_Codigo(tipo.toLowerCase(), codigoReciclavel);
       }
        return repository.findByTipo(tipo.toLowerCase());
    }
}
