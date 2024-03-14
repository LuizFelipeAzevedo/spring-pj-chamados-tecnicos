package br.com.fiap.springpjchamadostecnicos.repository;


import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

    @Query("SELECT e FROM Endereco e WHERE e.solicitante = :ID_SOLICITANTE")
    List<Endereco> findEnderecosBySolicitanteId(@Param("ID_SOLICITANTE") Long id);

    @Query("SELECT t FROM Telefone t WHERE t.solicitante = :ID_SOLICITANTE")
    List<Telefone> findTelefonesBySolicitanteId(@Param("ID_SOLICITANTE") Long id);
}
