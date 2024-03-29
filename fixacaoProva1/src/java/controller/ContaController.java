
package controller;

import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Conta;
import modelo.OperacoesConta;

@Named
@ApplicationScoped
public class ContaController {
    
    private final Map<String, Conta> contas = new HashMap<>();
    private final Map<String, List<OperacoesConta>> opContas = new HashMap<>();
    private Conta contaCorrente = new Conta();
    private Conta contaSelecionada;
    private BigDecimal valor;
    private String numero;
    private String loginComparacao;
    private String senhaComparacao;
    
    public String cadastrar(){
        if(!contas.containsKey((contaCorrente.getNumero()))){
            contas.put(contaCorrente.getNumero(), contaCorrente);
            Messages.addMessageSuccess("Conta corrente cadastrada.");
            contaCorrente = new Conta();
            return "/contaCorrente/listarContas.xhtml";
        }else{
            Messages.addMessageError("Esse número de conta já existe");
        }        
        return null;        
    }
    
    public String depositar() {
        try {
            Conta conta = contas.get(numero);
            if (conta != null) {
                conta.depositar(valor, loginComparacao, senhaComparacao);
                
                // Registrar a operação de depósito
                OperacoesConta operacao = new OperacoesConta(valor, "Depósito");
                operacao.setNumeroConta(numero);
                
                // Verificar se já existe uma lista de operações para esta conta
                List<OperacoesConta> operacoes = opContas.getOrDefault(numero, new ArrayList<>());
                operacoes.add(operacao);
                opContas.put(numero, operacoes);
                
                this.limparCampos();
                Messages.addMessageSuccess("Depósito realizado.");
                return "/contaCorrente/listarContas.xhtml";                
            }
            Messages.addMessageError("Conta corrente não encontrada.");            
        } catch (Exception ex) {
            Messages.addMessageError(ex.getMessage());
        }
        return null;
    }
    
    public String Sacar(){
        try {
            Conta conta = contas.get(numero);
            if (conta != null) {
                conta.sacar(valor, loginComparacao, senhaComparacao);
                
                // Registrar a operação de depósito
                OperacoesConta operacao = new OperacoesConta(valor, "Saque");
                operacao.setNumeroConta(numero);
                
                // Verificar se já existe uma lista de operações para esta conta
                List<OperacoesConta> operacoes = opContas.getOrDefault(numero, new ArrayList<>());
                operacoes.add(operacao);
                opContas.put(numero, operacoes);
                
                this.limparCampos();
                Messages.addMessageSuccess("Saque realizado.");
                
                return "/contaCorrente/listarContas.xhtml";                
            }
            Messages.addMessageError("Conta corrente não encontrada.");            
        } catch (Exception ex) {
            Messages.addMessageError(ex.getMessage());
        }
        return null;
    } 
    
    public void listarOperacoes() {
        if (numero != null && !numero.isEmpty()) {
            List<OperacoesConta> operacoesDaConta = opContas.get(numero);
            if (operacoesDaConta != null) {
                // Atualizar a lista de operações apenas para a conta específica
                opContas.put(numero, operacoesDaConta);
            } else {
                // Se não houver operações para a conta especificada, remover a entrada do mapa
                opContas.remove(numero);
            }
        }
    }

//    PARA PEGAR O NUMERO DA CONTA DIRETO, USAR ESSA PARTE
//    public String depositar() {
//        try {
////            Conta conta = contas.get(numero);
//            if (contaSelecionada.getNumero() != null) {
//                contaSelecionada.depositar(valor, loginComparacao, senhaComparacao);
//                this.limparCampos();
//                Messages.addMessageSuccess("Depósito realizado.");
//                return "/contaCorrente/listarContas.xhtml";                
//            }
//            Messages.addMessageError("Conta corrente não encontrada.");            
//        } catch (Exception ex) {
//            Messages.addMessageError(ex.getMessage());
//        }
//        return null;
//    }
//    
//    public String Sacar(){
//        try {
////            Conta conta = contaSelecionada.getNumero();;;
//            if (contaSelecionada.getNumero() != null) {
//                contaSelecionada.sacar(valor, loginComparacao, senhaComparacao);
//                this.limparCampos();
//                Messages.addMessageSuccess("Saque realizado.");
//                return "/contaCorrente/listarContas.xhtml";                
//            }
//            Messages.addMessageError("Conta corrente não encontrada.");            
//        } catch (Exception ex) {
//            Messages.addMessageError(ex.getMessage());
//        }
//        return null;
//    }
    
    private void limparCampos() {
        this.numero = "";
        this.valor = null;
        this.loginComparacao = "";
        this.senhaComparacao = "";
    }   
       
     public String paginaSacar(Conta conta){      
        this.contaSelecionada = conta;
        this.limparCampos();
        return "/contaCorrente/sacar.xhtml";
    }
    
    public String paginaDepositar(Conta conta){        
        this.contaSelecionada = conta;
        this.limparCampos();
        return "/contaCorrente/depositar.xhtml";
    }

    public Conta getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Conta contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Conta getContaSelecionada() {
        return contaSelecionada;
    }

    public void setContaSelecionada(Conta contaSelecionada) {
        this.contaSelecionada = contaSelecionada;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
    
    public Collection<Conta> getContas() {
        return contas.values();
    }   

    public Map<String, List<OperacoesConta>> getOpContas() {
        return opContas;
    }

    
    
    
    
    
   
}
