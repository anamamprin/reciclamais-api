package br.com.fiap.reciclamais.reciclamaisapi.repository;

import br.com.fiap.reciclamais.reciclamaisapi.model.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfertaRepository extends JpaRepository<Oferta,Long> {
    List<Oferta> findByTipo(String tipo);
    List<Oferta>findByTipoAndReciclavel_Codigo(String tipo, long codigo);
}
