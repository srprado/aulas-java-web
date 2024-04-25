package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CarroDAO;
import br.edu.ifsp.pep.model.Carro;
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
public class CarroController {

    @Inject
    private CarroDAO carroDAO;

    private Carro carro = new Carro();

    public void cadastrar() {
        try {
            carroDAO.cadastrar(carro);
            Messages.addMessageSuccess("Carro cadastrado.");
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addMessageError(e.getCause().getMessage());
        }

    }
    
    public List<Carro> buscarPelaPlaca(String placa) {
        return carroDAO.buscarPelaPlacaParcial(placa);
    }

    public List<Carro> listar() {
        return carroDAO.buscarTodos();
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

   

}
