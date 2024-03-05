package com.orch.stock.infrastructure.repository;

import com.orch.stock.domain.Cadastro;

public interface CadastroRepository {

    String enviarMensagemFila(String queueName, Cadastro message);
}
