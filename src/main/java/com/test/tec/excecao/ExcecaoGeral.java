package com.test.tec.excecao;
// Uma exceção geral pode não ser a melhor solução, mas por enquanto resolve o problema, pulverizar em diversas exceções seria ideal
public class ExcecaoGeral extends RuntimeException{

    public ExcecaoGeral(String geral){
        super(geral);
    }
}
