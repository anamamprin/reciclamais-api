package br.com.fiap.reciclamais.reciclamaisapi.repository;

import br.com.fiap.reciclamais.reciclamaisapi.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, String> {
}
