package com.orch.stock.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Cadastro {

    private String nome;
    private String cpf;
    private String anoNascimento;
    private String profissao;
    private String telefone;
    private String endereco;

}
