package com.orch.stock.mapper;

import br.com.orch.stock.presentation.representation.EnviarCadastro;
import com.orch.stock.domain.Cadastro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-05T14:26:44-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class CadastroMapperImpl implements CadastroMapper {

    @Override
    public Cadastro toDomain(EnviarCadastro enviarCadastro) {
        if ( enviarCadastro == null ) {
            return null;
        }

        Cadastro cadastro = new Cadastro();

        cadastro.setNome( enviarCadastro.getNome() );
        cadastro.setCpf( enviarCadastro.getCpf() );
        cadastro.setAnoNascimento( enviarCadastro.getAnoNascimento() );
        cadastro.setProfissao( enviarCadastro.getProfissao() );
        cadastro.setTelefone( enviarCadastro.getTelefone() );
        cadastro.setEndereco( enviarCadastro.getEndereco() );

        return cadastro;
    }
}
