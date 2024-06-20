
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.OpcaoPergunta;

public class RespostaDTO {
    
    private OpcaoPergunta OpcaoPergunta;
    
    private Long quantidade;

    //A ordem dos parâmetros deve ser igual ao retorno da consulta SQL

    public RespostaDTO(OpcaoPergunta OpcaoPergunta, Long quantidade) {
        this.OpcaoPergunta = OpcaoPergunta;
        this.quantidade = quantidade;
    }

    public OpcaoPergunta getOpcaoPergunta() {
        return OpcaoPergunta;
    }   

    public Long getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "RespostaDTO{" + "OpcaoPergunta=" + OpcaoPergunta + ", quantidade=" + quantidade + '}';
    }

    
    
       
}
