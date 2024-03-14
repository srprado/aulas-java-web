
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.OperacaoConta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Named
@ApplicationScoped
public class ContaController {
    
    private Float saldo = new Float(100);
    private Float valorSaque;
    private Float valorDeposito;
    private List<OperacaoConta> movimentacoes = new ArrayList<>();
    private OperacaoConta operacaoConta;
      
    public void sacar(){
        operacaoConta = new OperacaoConta();
        if(valorSaque>saldo){
            System.out.println("Saldo insuficiente para esse valor de saque!!");
        }else if(valorSaque == 0){
            System.out.println("Não é possível sacar este valor!!");
        }else{
            this.saldo -= valorSaque;
            operacaoConta.setOperacao("Saque");
            operacaoConta.setValor(valorSaque);
            operacaoConta.setData(LocalDate.now());
            movimentacoes.add(operacaoConta);
        }
    }
    
    public void depositar(){
        operacaoConta = new OperacaoConta();
        if(valorDeposito==0){
            System.out.println("Não é possível depositar esse valor!!");
        }else{
            this.saldo += valorDeposito;            
            operacaoConta.setOperacao("Depósito");
            operacaoConta.setValor(valorDeposito);
            operacaoConta.setData(LocalDate.now());
            movimentacoes.add(operacaoConta);
        }
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Float getValorSaque() {
        return valorSaque;
    }

    public void setValorSaque(Float valorSaque) {
        this.valorSaque = valorSaque;
    }

    public Float getValorDeposito() {
        return valorDeposito;
    }

    public void setValorDeposito(Float valorDeposito) {
        this.valorDeposito = valorDeposito;
    }

    public List<OperacaoConta> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<OperacaoConta> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public OperacaoConta getOperacaoConta() {
        return operacaoConta;
    }

    public void setOperacaoConta(OperacaoConta operacaoConta) {
        this.operacaoConta = operacaoConta;
    }
    
    
    
    
    
}
