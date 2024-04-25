package br.edu.ifsp.controller;

import br.edu.ifsp.dao.CarroDAO;
import br.edu.ifsp.modelo.Carro;
import br.edu.ifsp.pep.util.Messages;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CarroController {

    //@EJB
    @Inject
    private CarroDAO carroDAO;
    private Carro carro = new Carro();
       
    public void cadastrar() {
        System.out.println("Método cadastrar");
        try {
            carroDAO.cadastrar(carro);
            
            Messages.addMessageSuccess("Carro cadastrado!");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Messages.addMessageError("Erro ao cadastrar no banco de dados");
        }
        
    }
    
    public List<Carro> listar(){
        return carroDAO.findAll();    
   
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

}
