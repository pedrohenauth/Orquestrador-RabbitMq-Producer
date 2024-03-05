package com.orch.stock.infrastructure.rabbitConsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orch.stock.domain.Cadastro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "mensageria-teste")
    public void handleMessage(String message) throws JsonProcessingException {
        log.info("Recebida mensagem: '{}' ", message);
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("Mensagem convertida em objeto do tipo Mensagem: '{}' ", objectMapper.readValue(message, Cadastro.class));
    }
}
