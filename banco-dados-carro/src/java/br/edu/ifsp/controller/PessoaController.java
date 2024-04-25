
package br.edu.ifsp.controller;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class PessoaController implements Serializable{
    
    private Pessoa pessoaLogada;
    private Pessoa pessoa = new Pessoa();
    @Inject
    private PessoaDAO pessoaDAO;
    
    public String login() {
        System.out.println("metodo login...");
        pessoaLogada = pessoaDAO.findUser(pessoa.getLogin(), pessoa.getSenha());
        if (pessoaLogada != null) {
            Messages.addMessageSuccess("Usuário autenticado.");
            return "/index.xhtml";
        } else {
            Messages.addMessageError("Login ou Senha inválidos.");            
        }
        this.pessoa = new Pessoa();
        return null;
    }

    
    public String desconectar(){
        this.pessoaLogada = null;
        this.pessoa = new Pessoa();   
        return "login.xhtml";
    }
    
    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public void setPessoaLogada(Pessoa pessoaLogada) {
        this.pessoaLogada = pessoaLogada;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    
    
    
    
    
}
