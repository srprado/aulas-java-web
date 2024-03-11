
package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
//único objeto para a aplicação(projeto)
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
    
    public String iniciar() {
        System.out.println("Método iniciar"); 
        //se não houver retorno(método void) ou o retorno for null(método String) continua na mesma página. Quando há o retorno tem que ser uma página.
        //página .xhtml
        return "mensagem";
       
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
