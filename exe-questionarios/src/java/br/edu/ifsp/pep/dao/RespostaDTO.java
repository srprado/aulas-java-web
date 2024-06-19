
package br.edu.ifsp.pep.dao;

public class RespostaDTO {
    
    private String opcao;
    
    private Long quantidade;

    //A ordem dos parâmetros deve ser igual ao retorno da consulta SQL
    public RespostaDTO(String opcao, Long quantidade) {
        this.opcao = opcao;
        this.quantidade = quantidade;
    }
   
    public String getOpcao() {
        return opcao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "RespostaDTO{" + "opcao=" + opcao + ", quantidade=" + quantidade + '}';
    }   
}
