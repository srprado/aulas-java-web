
package br.edu.ifsp.pep.model;

import java.time.LocalDate;

public class OperacaoConta {
    
    private String operacao;
    private float valor;
    private LocalDate data;

    public OperacaoConta() {
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }   
}
