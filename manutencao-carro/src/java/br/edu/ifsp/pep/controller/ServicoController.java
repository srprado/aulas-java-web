package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ServicoDAO;
import br.edu.ifsp.pep.model.Carro;
import br.edu.ifsp.pep.model.Servico;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class ServicoController {

    @Inject
    private ServicoDAO servicoDAO;

    private Servico servico = new Servico();

    public void cadastrar() {
        try {
            servicoDAO.cadastrar(servico);
            Messages.addMessageSuccess("Serviço cadastrado.");
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addMessageError(e.getCause().getMessage());
        }

    }

    public List<Servico> listar() {
        return servicoDAO.findAll();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
