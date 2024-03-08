
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.ContaCorrente;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class contaCorrenteController implements Serializable{
    
    private List<ContaCorrente> contas = new ArrayList<>();
    private ContaCorrente conta = new ContaCorrente();
    private ContaCorrente contaSelecionada;
    private Double valor;  
     private String loginComparacao;
    private String senhaComparacao;
        
    public String cadastrarConta(){
        //verificar se o número já existe
        contas.add(conta);        
        conta = new ContaCorrente();        
        return "listaContas.xhtml";
    }
        
    public String paginaSacar(ContaCorrente conta){      
        this.contaSelecionada = conta;
        this.loginComparacao = null;
        this.senhaComparacao = null;
        this.valor = null;
        return "/operacoesConta/sacar.xhtml";
    }
    
    public String paginaDepositar(ContaCorrente conta){        
        this.contaSelecionada = conta;
        return "/operacoesConta/depositar.xhtml";
    }
        
    public String realizarSaque(){
        if(loginComparacao.equals("") || senhaComparacao.equals("")){
            Messages.addMessageWarning("Não pode haver campos vazios.Preencha-os");
            return null;
        }        
        if(this.contaSelecionada.getLogin().equals(loginComparacao) &&
                this.contaSelecionada.getSenha().equals(senhaComparacao)){
            if(this.contaSelecionada.getSaldo() >= valor){
                this.contaSelecionada.setSaldo(this.contaSelecionada.getSaldo()-valor);
                Messages.addMessageSuccess("Saque realizado.");
                return "/listaContas.xhtml";
            }else{
                Messages.addMessageError("Saldo insuficiente");  
                return null;
            }
        }
        Messages.addMessageWarning("Senha e/ou Login errado!");
        return null;
    }
    
    public String realizarDeposito(){
        if(this.contaSelecionada.getLogin().equals(loginComparacao) &&
                this.contaSelecionada.getSenha().equals(senhaComparacao)){
            this.contaSelecionada.setSaldo(this.contaSelecionada.getSaldo()+valor);
        }
        return "/listaContas.xhtml";
    }
      

    public List<ContaCorrente> getContas() {
        return contas;
    }

    public void setContas(List<ContaCorrente> contas) {
        this.contas = contas;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    public ContaCorrente getContaSelecionada() {
        return contaSelecionada;
    }

    public void setContaSelecionada(ContaCorrente contaSelecionada) {
        this.contaSelecionada = contaSelecionada;
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }  

    public String getLoginComparacao() {
        return loginComparacao;
    }

    public void setLoginComparacao(String loginComparacao) {
        this.loginComparacao = loginComparacao;
    }

    public String getSenhaComparacao() {
        return senhaComparacao;
    }

    public void setSenhaComparacao(String senhaComparacao) {
        this.senhaComparacao = senhaComparacao;
    }
}
