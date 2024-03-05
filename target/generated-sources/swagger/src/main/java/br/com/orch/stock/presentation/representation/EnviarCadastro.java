package br.com.orch.stock.presentation.representation;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EnviarCadastro
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-05T14:25:00.641786800-03:00[America/Sao_Paulo]")


public class EnviarCadastro   {
  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("cpf")
  private String cpf = null;

  @JsonProperty("anoNascimento")
  private String anoNascimento = null;

  @JsonProperty("profissao")
  private String profissao = null;

  @JsonProperty("telefone")
  private String telefone = null;

  @JsonProperty("endereco")
  private String endereco = null;

  public EnviarCadastro nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public EnviarCadastro cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Get cpf
   * @return cpf
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Pattern(regexp="^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")   public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public EnviarCadastro anoNascimento(String anoNascimento) {
    this.anoNascimento = anoNascimento;
    return this;
  }

  /**
   * Get anoNascimento
   * @return anoNascimento
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Pattern(regexp="^\\d{4}/\\d{2}/\\d{2}$")   public String getAnoNascimento() {
    return anoNascimento;
  }

  public void setAnoNascimento(String anoNascimento) {
    this.anoNascimento = anoNascimento;
  }

  public EnviarCadastro profissao(String profissao) {
    this.profissao = profissao;
    return this;
  }

  /**
   * Get profissao
   * @return profissao
   **/
  @Schema(description = "")
  
    public String getProfissao() {
    return profissao;
  }

  public void setProfissao(String profissao) {
    this.profissao = profissao;
  }

  public EnviarCadastro telefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  /**
   * Get telefone
   * @return telefone
   **/
  @Schema(description = "")
  
    public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public EnviarCadastro endereco(String endereco) {
    this.endereco = endereco;
    return this;
  }

  /**
   * Get endereco
   * @return endereco
   **/
  @Schema(description = "")
  
    public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnviarCadastro enviarCadastro = (EnviarCadastro) o;
    return Objects.equals(this.nome, enviarCadastro.nome) &&
        Objects.equals(this.cpf, enviarCadastro.cpf) &&
        Objects.equals(this.anoNascimento, enviarCadastro.anoNascimento) &&
        Objects.equals(this.profissao, enviarCadastro.profissao) &&
        Objects.equals(this.telefone, enviarCadastro.telefone) &&
        Objects.equals(this.endereco, enviarCadastro.endereco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, cpf, anoNascimento, profissao, telefone, endereco);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnviarCadastro {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    anoNascimento: ").append(toIndentedString(anoNascimento)).append("\n");
    sb.append("    profissao: ").append(toIndentedString(profissao)).append("\n");
    sb.append("    telefone: ").append(toIndentedString(telefone)).append("\n");
    sb.append("    endereco: ").append(toIndentedString(endereco)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
