package com.orch.stock.camel.router;

import com.orch.stock.infrastructure.repository.CadastroRepository;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
public class CadastroRouter extends RouteBuilder{

    public static final String ROUTE_CADASTRAMENTO = "direct:cadastroFlow";
    public static final String CADASTRO_BODY = "cadastroBody";

    CadastroRepository cadastroRepository;


    @Override
    public void configure() throws Exception {

        from(ROUTE_CADASTRAMENTO)
                .log("..: Iniciando rota de envio de cadastros :..")
                .setProperty(CADASTRO_BODY, body())
                .bean(cadastroRepository, "enviarMensagemFila")
                .log("..: Finalizando rota de envio de cadastro :..")
                .end();

    }
}
