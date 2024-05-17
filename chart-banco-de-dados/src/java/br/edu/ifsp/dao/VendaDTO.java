
package br.edu.ifsp.dao;

public class VendaDTO {
    
    private int mes;
    
    private double valor;
    
    
    //A ordem dos parâmetros deve ser igual ao retorno da consulta SQL
    public VendaDTO(int mes, double valor) {
        this.mes = mes;
        this.valor = valor;
    }

    public int getMes() {
        return mes;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "VendaDTO{" + "mes=" + mes + ", valor=" + valor + '}';
    }
    
    
    
    
}
