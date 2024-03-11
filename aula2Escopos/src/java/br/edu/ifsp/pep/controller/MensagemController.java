
package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class MensagemController {
    
    private String mensagem;
    private List<String> mensagens = new ArrayList<>();
    
    public void adicionar(){
        this.mensagens.add(mensagem);
        this.exibir();
    }
    
    public void exibir(){
        for (String msg : mensagens){
            System.out.println(msg);
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    }
    
    
   
    
    
    
}
