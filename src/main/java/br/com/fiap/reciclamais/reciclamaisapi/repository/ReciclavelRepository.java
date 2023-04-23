package br.com.fiap.reciclamais.reciclamaisapi.repository;

import br.com.fiap.reciclamais.reciclamaisapi.model.Reciclavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReciclavelRepository extends JpaRepository<Reciclavel, Long> {

}
