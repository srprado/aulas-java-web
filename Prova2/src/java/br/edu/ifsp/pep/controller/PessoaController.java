package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.model.Pessoa;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author aluno
 */
@Named
@SessionScoped
public class PessoaController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;

    private Pessoa pessoaLogada;

    private Pessoa pessoa = new Pessoa();

    public String login() {
        if (pessoa != null) {
            this.pessoaLogada = pessoaDAO.buscarPorLoginESenha(pessoa.getLogin(), pessoa.getSenha());
            if (this.pessoaLogada != null) {
                this.pessoa = new Pessoa();
                return "/index";
            }
            Messages.addMessageError("Login ou Senha inválidos.");
        }
        return null;
    }

    public void desconectar() {
        this.pessoaLogada = null;
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
