package com.test.tec.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CadastroEndereco {

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private boolean principal;

    private Long pessoaId;

}
