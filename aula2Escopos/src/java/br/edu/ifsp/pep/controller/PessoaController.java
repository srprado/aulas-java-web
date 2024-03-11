package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

//@Named: toda classe de controller deve ter 
@Named
//@RequestScope: tem o menor tempo de vida. A cada requisição ao servidor um novo objeto será criado
@RequestScoped
public class PessoaController {
    
    private Pessoa pessoa = new Pessoa();
    
//    //ou inicializar no controller
//    public PessoaController() {
//        Pessoa pessoa = new Pessoa();
//    }   
    
    public void dizerOla() {
        System.out.println(pessoa);
        
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    

    
    
    
    
}
