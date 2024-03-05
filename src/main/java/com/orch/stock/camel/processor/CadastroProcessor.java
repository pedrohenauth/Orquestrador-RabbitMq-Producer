package com.orch.stock.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CadastroProcessor implements Processor{

    public void process(Exchange exchange) throws Exception {

        String requestBody = exchange.getIn().getBody(String.class);
        exchange.getMessage().setBody(requestBody);

    }
}
