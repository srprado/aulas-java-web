
package br.edu.ifsp.controller;

import br.edu.ifsp.modelo.Venda;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class VendaController implements Serializable{
    
    private List<Venda> vendas = new ArrayList<>();
    private Venda venda = new Venda();
    private int codigoVenda;
    private BigDecimal valorPagamento;
    private Integer desconto;
    
    public void adicionar() {
        if (venda.getCodigo() <= 0) {
            Messages.addMessageWarning("O código da venda deve ser maior que zero.");
        } else if (venda.getValor().doubleValue()<1) {
            Messages.addMessageWarning("O valor deve ser maior que zero.");
        } else {
            vendas.add(venda);
            Messages.addMessageSuccess("Curso adicionado.");
            venda = new Venda();            
        }
    }
    
    public String prepararPagamento() {
        if (!vendas.isEmpty()) {
            valorPagamento = new BigDecimal(0);
            for(Venda v: vendas){            
                valorPagamento = valorPagamento.add(v.getValor());
            }
            return "/pagamento";
        }
        Messages.addMessageWarning("Adicione pelo menos um curso");
        return null;

    }
       
    public double getValorComDesconto(){
        if(desconto != null && desconto >0){
            return valorPagamento.doubleValue() - valorPagamento.doubleValue() * desconto.doubleValue()/100;
        }
        return valorPagamento.doubleValue();
    }
    
    public String finalizar(){
        Messages.addMessageSuccess("Venda finalizada. Total pago: "+getValorComDesconto());
        vendas = new ArrayList<>();
        desconto = 0;
        valorPagamento = new BigDecimal(0);        
        return "/home.xhtml";
    }
    

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

   
    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }
         
}
