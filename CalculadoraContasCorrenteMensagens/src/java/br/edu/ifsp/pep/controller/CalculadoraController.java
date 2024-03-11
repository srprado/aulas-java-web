
package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalculadoraController {
    
    private Float numero1;
    private Float numero2;
    private String operacao;
    private Float resultado;    
    
    public void calcular(){
        if(operacao.equals("+")){
            resultado = numero1+numero2;            
        }        
        else if(operacao.equals("-")){
            resultado = numero1-numero2;
        }
        else if(operacao.equals("*")){
            resultado=numero1*numero2;
        }
        else{
            if(numero2>0){
                resultado=numero1/numero2;
            }
            else{
                System.out.println("Não é possível realizar divisão por zero");
            }
            
        }
        
    }

    public Float getNumero1() {
        return numero1;
    }

    public void setNumero1(Float numero1) {
        this.numero1 = numero1;
    }

    public Float getNumero2() {
        return numero2;
    }

    public void setNumero2(Float numero2) {
        this.numero2 = numero2;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Float getResultado() {
        return resultado;
    }

    public void setResultado(Float resultado) {
        this.resultado = resultado;
    }
    
    
    
    
    
    
}
