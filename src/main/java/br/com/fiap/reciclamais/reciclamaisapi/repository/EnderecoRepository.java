package br.com.fiap.reciclamais.reciclamaisapi.repository;

import br.com.fiap.reciclamais.reciclamaisapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco,String> {
    List<Endereco> findByBairro_Codigo(long codigo);

}
