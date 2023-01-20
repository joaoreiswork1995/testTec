package com.test.tec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "logradouro", length = 125)
    private String logradouro;

    @Column(name = "cep", length = 9)
    private String cep; // string/varchar, em algumas regiões do país o cep usa letras

    @Column(name = "numero", length = 4)
    private String numero;  // string/varchar, em alguns locais pode haver uma combinação de letras e números, 55B por exemplo

    @Column(name = "cidade", length = 75)
    private String cidade;

    @Column(name = "principal")
    private boolean principal; // Não tive tempo de implementar um método para que apenas um endereco seja o principal, mas sei que é possível

    @ManyToOne
    @JoinColumn(name = "pessoaId", referencedColumnName = "id")
    private Pessoa pessoa;  // Acredito que a relação ManyToOne, como está aqui, faz mais sentido que um Array de Entidades/Objetos em pessoa

    public Endereco(String logradouro, String cep, String numero, String cidade, boolean principal, Pessoa pessoa){
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.principal = principal;
        this.pessoa = pessoa;
    }
}
