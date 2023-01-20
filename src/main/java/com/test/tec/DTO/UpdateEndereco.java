package com.test.tec.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEndereco {

    private Long enderecoId;

    private String logradouro;

    private String cep;

    private String cidade;

    private String numero;

    private boolean principal;

    private Long pessoaId;
}
