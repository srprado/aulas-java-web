
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDao;
import br.edu.ifsp.pep.modelo.Pessoa;
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
    private PessoaDao pessoaDao;

    public PessoaController() {
        System.out.println("construtor...");
    }   
    
    public String login(){
        System.out.println("método login...");
        pessoaLogada = pessoaDao.findUser(pessoa.getLogin(), pessoa.getSenha());
        if(pessoaLogada != null){
            Messages.addMessageSuccess("Usuário autenticado!");
            this.pessoa = new Pessoa();
            return "/index.xhtml";
        }else{
            Messages.addMessageError("Login ou senha invélidos");
        }
        return null;
    }
    
    public String desconectar(){
        this.pessoaLogada = null;
        this.pessoa = new Pessoa();
        return "/index.xhtml";
    } 
    
    public void cadastrar(){
        try {
            pessoaDao.cadastrar(pessoa);
            Messages.addMessageSuccess("Pessoa cadastrada!");
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addMessageError("Erro ao cadastrar pessoa");
            System.out.println(e.getCause().getMessage());
        }
        pessoa = new Pessoa();
       
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
