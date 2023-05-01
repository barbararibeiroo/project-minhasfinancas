package com.projectminhasfinancas.projectminhasfinancas.repository;

import com.projectminhasfinancas.projectminhasfinancas.model.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
