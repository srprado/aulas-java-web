
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDao;
import br.edu.ifsp.pep.modelo.NivelAcesso;
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
            Messages.addMessageError("Login ou senha inválidos");
        }
        this.pessoa = new Pessoa();
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
    
    public void cadastroInicial(){
        try {
            Pessoa pessoaAdmin = new Pessoa();
            pessoaAdmin.setCpf("111.111.111-11");
            pessoaAdmin.setNome("Admin");
            pessoaAdmin.setLogin("admin");
            pessoaAdmin.setSenha("admin");
            pessoaAdmin.setNivel_acesso(NivelAcesso.Administrador);
            pessoaDao.cadastrar(pessoaAdmin);
            Messages.addMessageSuccess("Pessoa Admin cadastrada!");
            
            Pessoa pessoaComum = new Pessoa();
            pessoaComum.setCpf("222.222.222-22");
            pessoaComum.setNome("Comum");
            pessoaComum.setLogin("comum");
            pessoaComum.setSenha("comum");
            pessoaComum.setNivel_acesso(NivelAcesso.Comum);
            pessoaDao.cadastrar(pessoaComum);
            Messages.addMessageSuccess("Pessoa Comum cadastrada!");
            
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addMessageError("Erro ao cadastrar pessoas");
            System.out.println(e.getCause().getMessage());
        }
       
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
