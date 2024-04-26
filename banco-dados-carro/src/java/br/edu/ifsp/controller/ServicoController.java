package br.edu.ifsp.controller;

import br.edu.ifsp.dao.ServicoDAO;
import br.edu.ifsp.modelo.Servico;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ServicoController {

    //@EJB
    @Inject
    private  ServicoDAO servicoDao;
    private Servico servico = new Servico();
          
    public ServicoController() {
                     
    }   
    
    public void cadastrar() {
        System.out.println("Método cadastrar");
        try {
            servicoDao.cadastrar(servico);
            
            Messages.addMessageSuccess("Serviço cadastrado!");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Messages.addMessageError("Erro ao cadastrar no banco de dados");
        }
        
    }    
    
    public List<Servico> listar(){
        return servicoDao.findAll();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
