package com.test.tec.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO {

    private Long pessoaId;

    private String nome;

    private LocalDate dataNasci;

    public ArrayList<EnderecoDTO> enderecos;


}
