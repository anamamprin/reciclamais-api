package br.com.fiap.reciclamais.reciclamaisapi.repository;

import br.com.fiap.reciclamais.reciclamaisapi.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByEstado_Uf(String uf);

}
