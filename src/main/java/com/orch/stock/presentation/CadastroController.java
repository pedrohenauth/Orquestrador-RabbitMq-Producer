package com.orch.stock.presentation;

import br.com.orch.stock.api.V1Api;
import br.com.orch.stock.presentation.representation.EnviarCadastro;
import com.orch.stock.mapper.CadastroMapper;
import com.orch.stock.service.CadastroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CadastroController implements V1Api {

    @Value("${spring.rabbitmq.name}")
    private String nomeFila;

    @Autowired
    private CadastroService cadastroService;
    @Autowired
    private CadastroMapper cadastroMapper;

    @Override
    public ResponseEntity<String> enviarCadastro(EnviarCadastro enviarCadastro) {

        log.info("..: Iniciando fluxo de cadastro :..");
        var cadastro = cadastroMapper.toDomain(enviarCadastro);
        var retorno = cadastroService.enviarMensagem(cadastro);
        log.info("..: Finalizando fluxo de cadastro :..");
        return ResponseEntity.ok(retorno);

    }
}

