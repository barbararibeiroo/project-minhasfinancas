package com.projectminhasfinancas.projectminhasfinancas.service;

import com.projectminhasfinancas.projectminhasfinancas.model.entity.Lancamento;
import com.projectminhasfinancas.projectminhasfinancas.model.enums.StatusLancamento;

import java.util.List;

public interface LancamentoService {

    Lancamento salvar(Lancamento lancamento);
    Lancamento atualizar(Lancamento lancamento);
    void deletar(Lancamento lancamento);
    List<Lancamento> buscar(Lancamento lancamentoFiltro);
    void atualizarStatus(Lancamento lancamento, StatusLancamento status);
    void validar(Lancamento lancamento);

}
