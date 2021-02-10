package br.com.pessoas.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id")
@EqualsAndHashCode
@Getter
@Setter
@ApiModel(value = "Pessoa", description = "Representa uma pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID da pessoa", example = "1")
    private Long codigo;

    @NotEmpty
    @ApiModelProperty(example = "José da Silva")
    private String nome;

    @ApiModelProperty(example = "Masculino")
    private String sexo;

    @Email
    @ApiModelProperty(example = "funcionario@softplan.com.br")
    private String email;

    @NotNull
    @Column(name = "data_nascimento")
    @ApiModelProperty(value = "Data de Nascimento", example = "2000-12-12")
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Cidade e Estado do seu nascimento", example = "Florianópolis - Santa Catarina")
    private String naturalidade;

    @ApiModelProperty(value = "País do seu nascimento", example = "Brasil")
    private String nacionalidade;

    @NotNull
    @NotEmpty
    @CPF
    @ApiModelProperty(value = "Número do seu cpf", example = "606.180.300-18")
    private String cpf;

    @Column(name = "data_do_cadastro")
    @CreationTimestamp
    @ApiModelProperty(value = "Data e hora do registro no sistema", example = "2021-01-30 10:10:00")
    private LocalDateTime dataDoCadastro;

    @Column(name = "data_da_alteracao")
    @UpdateTimestamp
    @ApiModelProperty(value = "Data e hora do registro de atualização no sistema", example = "2021-01-30 10:15:00")
    private LocalDateTime dataDaAlteracao;
}
