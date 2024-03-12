
package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conta implements Comparable<Conta>{
    
    private final List<OperacoesConta> operacoesConta = new ArrayList<>();
    
    private String numero;
    private String nomeCliente;
    private String login;
    private String senha;
    private BigDecimal saldo = new BigDecimal(0);
    
    
    private void registrarOperacoes(BigDecimal valor, String tipo){
        operacoesConta.add(new OperacoesConta(valor, tipo));
    }
    
    public void depositar(BigDecimal valor, String login, String senha) throws Exception {
        if (valor.doubleValue() > 0) {
            if (this.login.equals(login) && this.senha.equals(senha)) {
                this.saldo = this.saldo.add(valor);
                this.registrarOperacoes(valor, "Depósito");
            } else {
                throw new Exception("Login ou senha inválidos.");
            }
        } else {
            throw new Exception("Valor de depósito deve ser maior que Zero.");
        }
    }
    
    public void sacar(BigDecimal valor, String login, String senha) throws Exception {
        if (valor.doubleValue() > 0) {
            if (this.saldo.doubleValue() >= valor.doubleValue()) {
                if (this.login.equals(login) && this.senha.equals(senha)) {
                    this.saldo = this.saldo.subtract(valor);
                    this.registrarOperacoes(valor, "Saque");
                } else {
                    throw new Exception("Login ou senha inválidos.");
                }
            } else {
                throw new Exception("Saldo insuficiente.");
            }
        } else {
            throw new Exception("Valor deve ser maior do que Zero.");
        }
    } 

    public List<OperacoesConta> getOperacoesConta() {
        return operacoesConta;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public int compareTo(Conta conta) {
        return this.numero.compareTo(conta.getNumero());
    } 
}
