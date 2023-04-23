package br.com.fiap.reciclamais.reciclamaisapi.repository;

import br.com.fiap.reciclamais.reciclamaisapi.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
    List<Bairro> findByNome(String nome);
    List<Bairro> findByCidade_Codigo(long codigo);
}
