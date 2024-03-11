
package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
//Tempo de vida maior que o do request. Enquanto estiver na sessão do usuário ele mantém os dados
@SessionScoped
public class ProdutoController implements Serializable{
    
    private List<String> produtos = new ArrayList<>();
    private String nomeproduto;
    
    public void adicionar(){
        this.produtos.add(nomeproduto);
//        System.out.println(produtos.size());
        this.exibir();
    }
    
    private void exibir(){
        System.out.println("----Produtos----");
        for(String produto: produtos){
            System.out.println(produto);
        }
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }
    
    
    
    
    
    
    
}
