package com.orch.stock.service;

import com.orch.stock.domain.Cadastro;
import com.orch.stock.camel.router.CadastroRouter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CadastroService {


    @Autowired
    private ProducerTemplate template;

    @SneakyThrows
    public String enviarMensagem(Cadastro cadastro){
        return template.requestBody(CadastroRouter.ROUTE_CADASTRAMENTO, cadastro , String.class);
    }
}
