package br.edu.ifsp.controller;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PessoaController {

    //@EJB
    @Inject
    private PessoaDAO pessoaDAO;
    private Pessoa pessoa = new Pessoa();
    
    public void cadastrar() {
        System.out.println("Método cadastrar");
        try {
            pessoaDAO.cadastrar(pessoa);
            
            Messages.addMessageSuccess("Pessoa cadastrada!");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Messages.addMessageError("Erro ao cadastrar no banco de dados");
        }
        
    }
    
    public void listar(){
        List<Pessoa> pessoas = pessoaDAO.findAll();
        for(Pessoa p: pessoas){
            System.out.println(p.getNome());
        }
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
