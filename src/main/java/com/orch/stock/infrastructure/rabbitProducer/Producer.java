package com.orch.stock.infrastructure.rabbitProducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orch.stock.domain.Cadastro;
import com.orch.stock.infrastructure.repository.CadastroRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer implements CadastroRepository {

    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public Producer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Retryable(value = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    @SneakyThrows
    public String enviarMensagemFila(String queueName, Cadastro cadastro){

        try{
            log.info("..: Mensagem ({}) enviando para a queueName '{}' :..", cadastro, queueName);
            amqpTemplate.convertAndSend(queueName, objectMapper.writeValueAsString(cadastro));
            log.info("..: Mensagem ({}) enviada para a queueName '{}' :..", cadastro, queueName);
            return "Cadastramento realizado";
        } catch (Exception e){
            log.info("..: Ocorreu um erro ao enviar mensagem para fila. :..");
            throw new Exception("..: Ocorreu um erro ao enviar mensagem para fila :..");
        }
    }


}
