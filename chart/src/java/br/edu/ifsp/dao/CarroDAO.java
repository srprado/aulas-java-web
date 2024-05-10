
package br.edu.ifsp.dao;

import br.edu.ifsp.modelo.Carro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless //EJB - responsável pelas transações
public class CarroDAO {
   
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(Carro carro){
        em.persist(carro);
    }
    
    public List<Carro> findAll() {
        return em.createNamedQuery("Carro.findAll", Carro.class)
                .getResultList();
    }
    
    public Carro findByPlaca(String placa) {
        return em.createNamedQuery("Carro.findByPlaca", Carro.class)
                .setParameter("placa", placa)
                .getSingleResult();
    }
}
