package com.orch.stock.mapper;

import br.com.orch.stock.presentation.representation.EnviarCadastro;
import com.orch.stock.domain.Cadastro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CadastroMapper {

    Cadastro toDomain(EnviarCadastro enviarCadastro);

}
